package com.project.consorcio.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.consorcio.entity.Medicamento;
import com.project.consorcio.entity.TipoMedicamento;

public interface MedicamentoDAO extends JpaRepository<Medicamento, Integer> {
	
	
}
