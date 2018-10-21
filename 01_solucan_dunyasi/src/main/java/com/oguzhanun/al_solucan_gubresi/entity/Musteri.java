package com.oguzhanun.al_solucan_gubresi.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Entity
@Table(name="musteri")
public class Musteri {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotEmpty(message="zorunlu alan")
	@NotNull(message="zorunlu alan")
	@Column(name="isim")
	private String isim;
	
	@NotEmpty(message="zorunlu alan")
	@Column(name="soyisim")
	@NotNull(message="zorunlu alan")
	private String soyisim;
	
	@NotEmpty(message="zorunlu alan")
	@NotNull(message="zorunlu alan")
	@Column(name="adres")
	private String adres;
	
	@NotEmpty(message="zorunlu alan")
	@NotNull(message="zorunlu alan")
	@Email(message="Email formatında doldurulmalıdır")
	@Column(name="email")
	//@OneToOne(mappedBy="username", cascade=CascadeType.ALL)
	private String email;
	
	@Pattern(regexp="^[0-9]{11}", message="11 adet rakam girmeniz gerekmektedir")
	//@Size(message="11 adet rakam girmeniz gerekmektedir")
	@NotNull(message="zorunlu alan")
	@NotEmpty(message="zorunlu alan")
	@Column(name="telefon")
	private String telefon;
	
	@NotEmpty(message="zorunlu alan")
	@NotNull(message="zorunlu alan")
	@Column(name="sifre")
	//@OneToOne(mappedBy="password", cascade=CascadeType.ALL)
	private String sifre;
	
	@NotEmpty(message="zorunlu alan")
	@NotNull(message="zorunlu alan")
	@Column(name="sifre_kontrol")
	private String sifreKontrol;
	
	
	public Musteri() {
		
	}

	public Musteri(int id, String isim, String soyisim, String kullanici_adi, String adres, String email, String telefon) {
		this.id = id;
		this.isim = isim;
		this.soyisim = soyisim;
		
		this.adres = adres;
		this.email = email;
		this.telefon = telefon;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public String getSoyisim() {
		return soyisim;
	}

	public void setSoyisim(String soyisim) {
		this.soyisim = soyisim;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getSifre() {
		return sifre;
	}

	public void setSifre(String sifre) {
		this.sifre = sifre;
	}

	public String getSifreKontrol() {
		return sifreKontrol;
	}

	public void setSifreKontrol(String sifreKontrol) {
		this.sifreKontrol = sifreKontrol;
	}

	@Override
	public String toString() {
		return "Musteri [id=" + id + ", isim=" + isim + ", soyisim=" + soyisim + ", kullanici_adi="
				+ ", adres=" + adres + ", email=" + email + ", telefon=" + telefon + "]";
	}
	
}
