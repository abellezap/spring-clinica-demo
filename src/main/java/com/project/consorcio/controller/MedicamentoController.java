package com.project.consorcio.controller;

import java.text.SimpleDateFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.consorcio.entity.Laboratorio;
import com.project.consorcio.entity.Medicamento;
import com.project.consorcio.entity.TipoMedicamento;
import com.project.consorcio.service.LaboratorioService;
import com.project.consorcio.service.MedicamentoService;
import com.project.consorcio.service.TipoMedicamentoService;

@Controller
@RequestMapping(value = "/medicamento")
public class MedicamentoController {

	@Autowired
	private MedicamentoService medicamentoService;
	
	@Autowired
	private TipoMedicamentoService tipoMedicamentoService;
	
	@Autowired
	private LaboratorioService laboratorioService;
	
	
	
	@RequestMapping(value = "/")
	public String index(Model model){
		//crear atributos
		model.addAttribute("medicamentos",medicamentoService.listarTodos());
		model.addAttribute("laboratorios",laboratorioService.listAll());
		
		return "medicamento";
	}
	
	@RequestMapping(value = "/guardar")
	public String guardar(@RequestParam("codigo") int cod,@RequestParam("nombre") String nom,
						  @RequestParam("descripcion") String des,@RequestParam("stock") int stock,
						  @RequestParam("precio") double pre,@RequestParam("fecha") String fec,
						  @RequestParam("tipo") int codTipo,RedirectAttributes redirect){
		try {
			//crear objeto de la clase Medicamento
			Medicamento bean=new Medicamento();
			//setear
			bean.setNomMed(nom);
			bean.setDesMed(des);
			bean.setStoMed(stock);
			bean.setPreMed(pre);
			bean.setFecFabMed(new SimpleDateFormat("yyyy-MM-dd").parse(fec));
			bean.setTipoMedicamento(new TipoMedicamento(codTipo));
			//validar cod
			if(cod!=0) {
				bean.setCodMed(cod);
				medicamentoService.actualizar(bean);
				redirect.addFlashAttribute("MENSAJE","Medicamaneto actualizado...");
			}
			else {
				medicamentoService.registrar(bean);
				redirect.addFlashAttribute("MENSAJE","Medicamaneto guardado...");
			}
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","Error al guardar medicamento...");
			e.printStackTrace();
		}
		
		return "redirect:/medicamento/";
	}
	
	@RequestMapping(value = "/buscar")
	@ResponseBody
	public Medicamento buscar(@RequestParam("codigo") int cod) {
		Medicamento bean=null;
		try {
			bean=medicamentoService.buscar(cod);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}
	
	@RequestMapping(value = "/eliminar")
	public String eliminar(@RequestParam("codigo") int cod,RedirectAttributes redirect) {
		try {
			medicamentoService.eliminar(cod);
			redirect.addFlashAttribute("MENSAJE","Medicamento eliminado");
			
		} catch (Exception e) {
			e.printStackTrace();
			redirect.addFlashAttribute("MENSAJE","Error en la eliminación");
		}
		return "redirect:/medicamento/";
	}
	
	@RequestMapping(value = "/listarTiposAtLaboratorio")
	@ResponseBody
	public List<TipoMedicamento> listarTiposAtLaboratorio(@RequestParam("codLab") int codigo){
		List<TipoMedicamento> lista=null;
		try {
			lista=tipoMedicamentoService.listarTiposAtLaboratorio(codigo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	
	
}














