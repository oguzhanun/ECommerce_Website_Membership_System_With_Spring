package com.oguzhanun.al_solucan_gubresi.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class GirisController {

	
	@GetMapping("/uyeGirisSayfasi")
	public String uyeGirisSayfasi() {
		
		return "uyeGirisSayfasi";
	}
	
	@GetMapping("/accessDenied-page")
	public String showAccessDeniedPage() {
		
		//return "login-page";
		return "accessDenied-page";
	}
	
	@RequestMapping("/uyeGirisi")
	public String uyeGirisi(Model model) {
		
		return "uyeGirisi";
	}
	
}
