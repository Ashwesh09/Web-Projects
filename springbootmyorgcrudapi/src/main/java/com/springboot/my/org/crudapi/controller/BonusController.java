package com.springboot.my.org.crudapi.controller;

import java.sql.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.my.org.crudapi.model.Bonus;
import com.springboot.my.org.crudapi.service.BonusService;

@RestController
@RequestMapping("/bonus")
public class BonusController {	
	
	@Autowired
	private BonusService bonusService;
	
	private static final Logger log = LoggerFactory.getLogger(BonusController.class);

	
	@GetMapping({"/bonus/{id}"})
	public Bonus showInfo(@PathVariable Integer id) {
		return bonusService.getBonus(id);
	}
	
	@GetMapping({"/showBonus"})
	public Bonus showBonus(@RequestParam Integer bonusId) {
		return bonusService.getBonus(bonusId);
	}
	
	@GetMapping("/all")
	public List<Bonus> showAllBonuss() {
		return bonusService.getAllBonuss();	
	}
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Boolean createBonus(@RequestBody Bonus bonus) {
		log.info("Bonus created.");
		return bonusService.createBonus(bonus);
	}

	@PostMapping(path = "/createBonus", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE,MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(HttpStatus.CREATED)
	public Boolean createBonusByForm(@RequestParam MultiValueMap<String, String> pm) {
		Bonus w = new Bonus();
		w.setWorkerRefId(Integer.parseInt(pm.getFirst("workerRefId")));
		w.setBonusAmount(Integer.parseInt(pm.getFirst("bonusAmount")));
		w.setBonusDate(Date.valueOf(pm.getFirst("bonusDate")));
		log.info("Bonus created.");

		return bonusService.createBonus(w);
	}
	
	@GetMapping("/delete/{id}")
	public Boolean deleteBonus(@PathVariable Integer id) {
		return bonusService.deleteBonus(id);
	}
	@PostMapping(path="/deleteForm" ,
			consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String deleteBonusForm(@RequestParam Integer bonusId) {
		bonusService.deleteBonus(bonusId);
		return "Deleted Bonus No:"+ bonusId;
	}
	
	@PatchMapping("update/{id}")
	public Boolean updateBonus(@RequestBody Bonus b) {
		return bonusService.updateBonus(b);
	}
}
