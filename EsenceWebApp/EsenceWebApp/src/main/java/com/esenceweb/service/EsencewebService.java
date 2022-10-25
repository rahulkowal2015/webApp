package com.esenceweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esenceweb.dao.EsencewebDao;
import com.esenceweb.model.Esenceweb;

@Service
@Transactional
public class EsencewebService {
	
	@Autowired
	private EsencewebDao dao;
	
	public List<Esenceweb> listAll() {
		return dao.findAll();
	}
	
	public void save(Esenceweb webs) {
		dao.save(webs);
	}
	
	public Esenceweb get(long id) {
		return dao.findById(id).get();
	}
	
	public void delete(long id) {
		dao.deleteById(id);
	}

}
