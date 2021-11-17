package com.project.consorcio.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.consorcio.entity.TipoMedicamento;

public interface TipoMedicamentoDAO extends JpaRepository<TipoMedicamento, Integer>{
	
	@Query("select tipo from TipoMedicamento tipo where tipo.laboratorio.codigo=?1")
	public List<TipoMedicamento> listarTiposAtLaboratorio(int codLab);
}
