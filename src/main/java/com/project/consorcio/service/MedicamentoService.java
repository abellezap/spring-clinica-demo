package com.project.consorcio.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.consorcio.dao.MedicamentoDAO;
import com.project.consorcio.entity.Medicamento;

@Service
public class MedicamentoService{
	
	@Autowired
	private MedicamentoDAO medicamentoDAO;
	
	
	public void registrar(Medicamento bean) {
		medicamentoDAO.save(bean);
	}

	public void actualizar(Medicamento bean) {
		medicamentoDAO.save(bean);
	}

	public void eliminar(int cod) {
		medicamentoDAO.deleteById(cod);
	}

	public Medicamento buscar(int cod) {
		return medicamentoDAO.findById(cod).orElse(null);
	}

	public List<Medicamento> listarTodos() {
		return medicamentoDAO.findAll();
	}

}
