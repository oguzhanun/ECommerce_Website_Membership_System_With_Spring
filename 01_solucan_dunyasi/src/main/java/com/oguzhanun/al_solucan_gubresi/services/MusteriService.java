package com.oguzhanun.al_solucan_gubresi.services;

import javax.validation.Valid;

import com.oguzhanun.al_solucan_gubresi.entity.Musteri;
import com.oguzhanun.al_solucan_gubresi.entity.VerificationToken;

public interface MusteriService {

	void setMusteri(@Valid Musteri musteri);

	boolean kullaniciVarMi(String email);

	void setToken(VerificationToken verificationToken);

	VerificationToken findToken(String token);

	void uyeSil(String user);

	void setYeniSifre(String user, String yeniSifre);

	

}
