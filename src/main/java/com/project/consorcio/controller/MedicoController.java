package com.project.consorcio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/medico")
public class MedicoController {
	
	public void incio(){
		
	}
	
	public String datos() {
		return "hola";
	}
	
}
