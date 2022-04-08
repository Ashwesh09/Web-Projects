package com.springboot.my.org.crudapi.service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.my.org.crudapi.model.Bonus;
import com.springboot.my.org.crudapi.repository.BonusRepository;

@Service
public class BonusService {
	@Autowired
	private BonusRepository bonusRepository;

	public Bonus getBonus(Integer id) {
		try {
			return this.bonusRepository.getBonusById(id);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	public List<Bonus> getAllBonuss() {
		try {
			return this.bonusRepository.getAllBonuses();
		} catch (SQLException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	public Boolean createBonus(Bonus bonus) {
		try {
			return this.bonusRepository.create(bonus);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}


	public Boolean deleteBonus(Integer id) {
		try {
			return this.bonusRepository.delete(id);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Boolean updateBonus(Bonus b) {
		try {
			return this.bonusRepository.update(b);
		}
		catch(SQLException e){
			return false;
		}
	}
}