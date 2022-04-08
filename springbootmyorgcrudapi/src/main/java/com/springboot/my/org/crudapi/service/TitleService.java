package com.springboot.my.org.crudapi.service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.my.org.crudapi.model.Title;
import com.springboot.my.org.crudapi.repository.TitleRepository;

@Service
public class TitleService {
	@Autowired
	private TitleRepository titleRepository;

	public Title getTitle(Integer id) {
		try {
			return this.titleRepository.getTitleById(id);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	public List<Title> getAllTitles() {
		try {
			return this.titleRepository.getAllTitles();
		} catch (SQLException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	public Boolean createTitle(Title title) {
		try {
			return this.titleRepository.create(title);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}


	public Boolean deleteTitle(Integer id) {
		try {
			return this.titleRepository.delete(id);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Boolean updateTitle(Title t) {
		try {
			return this.titleRepository.update(t);
		}
		catch(SQLException e){
			return false;
		}
	}
}