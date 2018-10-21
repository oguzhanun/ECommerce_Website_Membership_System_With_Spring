package com.oguzhanun.al_solucan_gubresi.services;


import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.oguzhanun.al_solucan_gubresi.daos.MusteriDao;
import com.oguzhanun.al_solucan_gubresi.entity.Musteri;
import com.oguzhanun.al_solucan_gubresi.entity.VerificationToken;


@Service
public class MusteriServiceImpl implements MusteriService {

	
	@Autowired
	private MusteriDao musteriDao;
	
	
	@Override
	@Transactional
	public void setMusteri(@Valid Musteri musteri) {
		
		musteriDao.setMusteri(musteri);

	}
	
	@Override
	@Transactional//(readOnly = true, propagation = Propagation.REQUIRED, rollbackFor = java.lang.Exception.class)
	public boolean kullaniciVarMi(String email) {
		
		try {
			
			return musteriDao.kullaniciVarMi(email);
		
		} catch(Exception exc){
			
			System.out.println(exc.getMessage());
			return true;
		}
		
	}

	@Override
	@Transactional
	public void setToken(VerificationToken verificationToken) {
		
		musteriDao.setToken(verificationToken);
	}

	@Override
	@Transactional
	public VerificationToken findToken(String token) {
		
		return musteriDao.findToken(token);
	}

	@Override
	@Transactional
	public void uyeSil(String user) {
		musteriDao.uyeSil(user);
		
	}

	@Override
	@Transactional
	public void setYeniSifre(String user, String yeniSifre) {
		musteriDao.setYeniSifre(user, yeniSifre);		
	}

}
