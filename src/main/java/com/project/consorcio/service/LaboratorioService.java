package com.project.consorcio.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.consorcio.dao.LaboratorioDAO;
import com.project.consorcio.entity.Laboratorio;

@Service
public class LaboratorioService{
	@Autowired
	private LaboratorioDAO laboratorioDAO;
	
	
	
	public List<Laboratorio> listAll() {
		return laboratorioDAO.findAll();
	}

}
