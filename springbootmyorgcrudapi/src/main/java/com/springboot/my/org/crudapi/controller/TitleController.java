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

import com.springboot.my.org.crudapi.model.Title;
import com.springboot.my.org.crudapi.service.TitleService;


@RestController
@RequestMapping("/title")
public class TitleController {	
	
	@Autowired
	private TitleService titleService;
	
	private static final Logger log = LoggerFactory.getLogger(TitleController.class);

	
	@GetMapping({"/title/{id}"})
	public Title showInfo(@PathVariable Integer id) {
		return titleService.getTitle(id);
	}
	
	@GetMapping({"/showTitle"})
	public Title showTitle(@RequestParam Integer titleId) {
		return titleService.getTitle(titleId);
	}
	
	@GetMapping("/all")
	public List<Title> showAllTitles() {
		return titleService.getAllTitles();	
	}
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Boolean createTitle(@RequestBody Title title) {
		log.info("Title created.");
		return titleService.createTitle(title);
	}

	@PostMapping(path = "/createTitle", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE,MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(HttpStatus.CREATED)
	public Boolean createTitleByForm(@RequestParam MultiValueMap<String, String> pm) {
		Title w = new Title();
		w.setWorkerRefId(Integer.parseInt(pm.getFirst("workerRefId")));
		w.setWorkerTitle(pm.getFirst("title"));
		w.setAffectedFrom(Date.valueOf(pm.getFirst("affectedFrom")));
		log.info("Title created.");

		return titleService.createTitle(w);
	}
	
	@GetMapping("/delete/{id}")
	public Boolean deleteTitle(@PathVariable Integer id) {
		return titleService.deleteTitle(id);
	}
	@PostMapping(path="/deleteForm" ,
			consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String deleteTitleForm(@RequestParam Integer titleId) {
		titleService.deleteTitle(titleId);
		return "Deleted Title No:"+ titleId;
	}
	@PatchMapping("update/{id}")
	public Boolean updateBonus(@RequestBody Title t) {
		return titleService.updateTitle(t);
	}
}