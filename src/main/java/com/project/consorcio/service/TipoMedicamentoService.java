package com.project.consorcio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.consorcio.dao.TipoMedicamentoDAO;
import com.project.consorcio.entity.TipoMedicamento;

@Service
public class TipoMedicamentoService{

	@Autowired
	private TipoMedicamentoDAO tipoMedicamentoDAO; 
	
	
	public List<TipoMedicamento> listarTiposAtLaboratorio(int codLab) {
		return tipoMedicamentoDAO.listarTiposAtLaboratorio(codLab);
	}

}
