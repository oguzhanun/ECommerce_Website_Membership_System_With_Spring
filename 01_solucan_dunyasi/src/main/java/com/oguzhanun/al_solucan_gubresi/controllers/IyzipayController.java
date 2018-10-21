package com.oguzhanun.al_solucan_gubresi.controllers;


import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/iyzipay")
public class IyzipayController {

	
	@RequestMapping("/odemeSayfasi")
	public String odemeSayfasi(Model model) throws MalformedURLException{
//		try {
//			URL url = new URL("https://secure.payu.com.tr/order/lu.php");
//			HttpURLConnection httpUrlConnection= (HttpURLConnection) url.openConnection();
//			httpUrlConnection.setRequestMethod("post");
//			OutputStream outputStream = httpUrlConnection.getOutputStream();
//			DataOutputStream dos = new DataOutputStream(outputStream);
//			dos.writeBytes("");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		return "odemeSayfasi";
	}
	
	@RequestMapping("/odemeDonusu")
	public String odemeDonusu(Model model, HttpServletRequest request) {
		
		return "odemeDonusu";
	}
}
