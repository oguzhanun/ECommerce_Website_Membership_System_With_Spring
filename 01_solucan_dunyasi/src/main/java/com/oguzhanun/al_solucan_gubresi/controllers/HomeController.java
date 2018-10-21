package com.oguzhanun.al_solucan_gubresi.controllers;


import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import com.oguzhanun.al_solucan_gubresi.entity.Musteri;
import com.oguzhanun.al_solucan_gubresi.entity.User;
import com.oguzhanun.al_solucan_gubresi.entity.VerificationToken;
import com.oguzhanun.al_solucan_gubresi.event.OnRegistrationCompleteEvent;
import com.oguzhanun.al_solucan_gubresi.services.MusteriService;


@Controller
public class HomeController {

	
	@Autowired
	private MusteriService musteriService;
	
	@Autowired
	private UserDetailsManager userDetailsManager;
	
	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;
	
	private PasswordEncoder passwordEncoder;
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@GetMapping("/")
	public String girisSayfasi(Model model) {
		
		return "anasayfa";
	}
	
	@GetMapping("/anasayfa")
	public String anasayfa(Model model) {
		
		return "anasayfa";
	}
	
	@GetMapping("/uyeOlustur")
	public String uyeOlustur(Model model) {
		
		Musteri musteri = new Musteri();
		
		model.addAttribute("musteri", musteri);
		
		return "uyeOlustur";
	}
	
	@PostMapping("/uyeKayit")
	public String uyeKayit(@Valid @ModelAttribute Musteri musteri, BindingResult bindingResult, Model model, WebRequest request) {
		
		//KAYNAKLAR
		passwordEncoder = new BCryptPasswordEncoder();
		String sifre = musteri.getSifre();
		String sifreKontrol = musteri.getSifreKontrol();
		
		//ŞİFRELER UYUMLU MU KONTROL ET
		if (sifre != null && sifreKontrol != null && !musteri.getSifre().equals(musteri.getSifreKontrol())){
			
			model.addAttribute("uyumsuz", true);
			
			System.out.println("uyumsuz");
			return "uyeOlustur";
		}
		
		//FORM KURALLARINA AYKIRILIK VAR MI? KONTROL ET
		if(bindingResult.hasErrors()) {
			return "uyeOlustur";
		} 
		
		//KULLANICI ADININ VERİTABANINDA ZATEN MEVCUT OLUP OLMADIĞINI KONTROL ET
		//if(musteriService.kullaniciVarMi(musteri.getEmail())) {
		if(userDetailsManager.userExists(musteri.getEmail())) {	
			model.addAttribute("kullaniciVar", true);
			
			System.out.println("kullanıcı var...");
			
			return "uyeOlustur";
		} 
		
		//HERŞEY YOLUNDA İSE KAYIT İŞLEMİNİ GERÇEKLEŞTİR
		else {
			//Kodlanmış şifreyi oluştur..
			String kodluSifre = passwordEncoder.encode(musteri.getSifre());
			kodluSifre = "{bcrypt}"+ kodluSifre;
			
			boolean isEnabled = false;
			
			//Autority ile ilgili kısım
			List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_USER");
			
			//Kullanıcı oluştur...
			User user = new User(musteri.getEmail(), kodluSifre, isEnabled, authorities );
			
			try {
				
				String appUrl = request.getContextPath();
				System.out.println("context path alındı...");
				applicationEventPublisher.publishEvent(new OnRegistrationCompleteEvent(musteri, request.getLocale(), appUrl));
				System.out.println("event publish edildi...");
			}catch(Exception exc) {
				exc.printStackTrace();
				return "uyeOlustur"; //Başka bir sayfa daha sonra buraya yapılması gerekiyor...
			}
			
			//Müşteri veritabanını da burada oluşturuyoruz...
			musteriService.setMusteri(musteri);
			
			//Kullanıcıyı veritabanına kaydet...
			userDetailsManager.createUser(user);
			
			//musteri.setSifre("{noop}" + musteri.getSifre());
			//musteri.setSifreKontrol("{noop}" + musteri.getSifreKontrol());
			
			return "uyeKayit";
		}
	}
	
	@RequestMapping("/uyeOnay/{token}")
	public String uyeOnay(@PathVariable("token") String token, Model model) {
		
		//token'ı alıp veritabanında sorgulama yapmalıyız.
		
		//Eğer token veritabanında mevcut ve bekleme süresi dolmamış ise geriye bir kullanıcı adı göndermesi gerekiyor.
		
		//Geriye dönen kullanıcı adı users tablosunda güncellenerek enabled sütunu true ya çevrilmeli...
		
		VerificationToken vt;
		
		if((vt = musteriService.findToken(token)) != null){
			
			if(System.currentTimeMillis() < vt.getExpiryDate().getTime()) {
				String kullaniciAdi = vt.getEmail();
				
				UserDetails userDetails = userDetailsManager.loadUserByUsername(kullaniciAdi);
				
				User userOnay;
				
				userOnay = new User(kullaniciAdi, userDetails.getPassword(), true, AuthorityUtils.createAuthorityList("ROLE_USER"));
				
				userDetailsManager.updateUser(userOnay);
			
				return "anasayfa";
			
			}//else diyerek burada zaman aşımına ilişkin bir sayfa yayınlamak gerekiyor.
			
		}
		
		return "uyeKayit"; //Hatalı url kullanıldığını ifade eden bir sayfa yapılmalı...
	}
	
	@RequestMapping("/uyelikSil")
	public String uyelikSil(@RequestParam("user") String user, Model model) {
		
		musteriService.uyeSil(user);
		
		return "anasayfa";//üyeliğiniz başarılı bir şekilde sonlandırılmıştır yazılı bir sayfa ve anasayfaya link...
	}
	
	@RequestMapping("/sifreDegistir")
	public String sifreDegistir(Model model) {
		
		return "sifreDegistir";
	}
	
	@GetMapping("/sifreDegisikliginiIsle")
	public String sifreDegisikliginiIsle(@RequestParam("user") String user,
			@RequestParam("eskiSifre") String eskiSifre, @RequestParam("yeniSifre") String yeniSifre,
			@RequestParam("sifreKontrol") String sifreKontrol, Model model) {

		//SecurityContextHolder.getContext().getAuthentication();
		
		String sifre = userDetailsManager.loadUserByUsername(user).getPassword();
		sifre = sifre.substring(8);
		
		passwordEncoder = new BCryptPasswordEncoder();
		

		System.out.println("eski şifre = " + sifre);
		
		if(eskiSifre == null || !passwordEncoder.matches(eskiSifre, sifre)) {
			
			model.addAttribute("uyumsuz", true);
			return "sifreDegistir";
		}
		
		if(yeniSifre == null || sifreKontrol == null || !yeniSifre.equals(sifreKontrol)) {
			model.addAttribute("sifreKontrolDurumu", true);
			return "sifreDegistir";
		}
		
		//tabloların güncellenmesi gerekmektedir...
		String kodluSifre = passwordEncoder.encode(yeniSifre);
		kodluSifre = "{bcrypt}"+ kodluSifre;
		
		//Autority ile ilgili kısım
		List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_USER");
		
		//Kullanıcı oluştur...
		User yeniSifreliKullanici = new User(user, kodluSifre, true, authorities );
		
		userDetailsManager.updateUser(yeniSifreliKullanici);
		
		musteriService.setYeniSifre(user, yeniSifre);
		
		return "anasayfa";
	}
	
}









