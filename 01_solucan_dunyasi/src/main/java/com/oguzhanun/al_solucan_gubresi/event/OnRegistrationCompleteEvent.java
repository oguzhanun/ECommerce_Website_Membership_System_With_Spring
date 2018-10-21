package com.oguzhanun.al_solucan_gubresi.event;


import java.util.Locale;
import org.springframework.context.ApplicationEvent;
import com.oguzhanun.al_solucan_gubresi.entity.Musteri;


public class OnRegistrationCompleteEvent extends ApplicationEvent {

	
	private static final long serialVersionUID = -7006438570020078398L;

	private String appUrl;
    
	private Locale locale;
    
    private Musteri musteri;
    
    
	public OnRegistrationCompleteEvent( Musteri musteri, Locale locale, String appUrl) {
		
		super(musteri);
		
		this.appUrl = appUrl;
		this.locale = locale;
		this.musteri = musteri;
		System.out.println("onRegistreationComplete'de ...");
	}

	
	public String getAppUrl() {
		return appUrl;
	}

	public void setAppUrl(String appUrl) {
		this.appUrl = appUrl;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}


	public Musteri getMusteri() {
		return musteri;
	}


	public void setMusteri(Musteri musteri) {
		this.musteri = musteri;
	}


	@Override
	public String toString() {
		return "OnRegistrationCompleteEvent [appUrl=" + appUrl + ", locale=" + locale + ", musteri=" + musteri + "]";
	}

}
