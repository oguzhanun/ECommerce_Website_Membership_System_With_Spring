package com.oguzhanun.al_solucan_gubresi.daos;


import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.oguzhanun.al_solucan_gubresi.entity.Musteri;
import com.oguzhanun.al_solucan_gubresi.entity.VerificationToken;


@Repository
public class MusteriDaoImpl implements MusteriDao {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public void setMusteri(@Valid Musteri musteri) {
		
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(musteri);
		
		/*Users user = new Users();
		user.setEnabled(1);
		user.setPassword(musteri);
		user.setUsername(musteri);
		session.saveOrUpdate(user);
		
		Authorities authorities = new Authorities();
		authorities.setUsername(user);
		authorities.setAuthority("ROLE_USER");
		
		session.save(authorities);
		 */
	}


	@Override
	//@Transactional(readOnly = true, propagation = Propagation.REQUIRED, rollbackFor = java.lang.Exception.class)
	//Burada sorgulama yapılırken eğer Users sınıfı aracılığıyla veritabanına çıkılırsa aranan email esas olarak Users 
	//tablosunda olmadığında ikinci bir tablo için başka bir session kullanılmaya çalışıyor sanırsam. O yüzden burada bir
	//erişim hatası alıyoruz. Bunu zaten aslında hata mesajında ima ediyor. Bu hücreye erişemiyorum diye. İşte bu yüzden
	//burada arama yapılırken email verisinin esas tablosu olan Musteri sınıfının tablosu kullanılmak zorunda. 
	//Teknik olarak ayrıca ikinci bir session açılmış olduğundan (muhtemelen) catch edilen hata bir rollback olayına sebep oluyor ve
	//hata yakalanamıyor. Burada bu yüzden başka bir hata mesajı alınıyor...(Transaction ile ilgili)
	public boolean kullaniciVarMi(String email) {
		
		boolean result = false;
		Session session = sessionFactory.getCurrentSession();
		
		Query<Musteri> query = session.createQuery("from Musteri where email=:email", Musteri.class);
		query.setParameter("email", email);
	
		List<Musteri> users = new ArrayList<>();
		
		users = query.getResultList();
		
		if(users.isEmpty()) {
			
			result = false;
			
		} else result = true;
		
		return result;
	
	}


	@Override
	public void setToken(VerificationToken verificationToken) {
		
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(verificationToken);
	}


	@Override
	public VerificationToken findToken(String token) {
		Session session = sessionFactory.getCurrentSession();
		Query<VerificationToken> tokenQuery = session.createQuery("from VerificationToken where token=:token", VerificationToken.class);
		
		tokenQuery.setParameter("token",token);
		System.out.println(token);
		List<VerificationToken> tokenList = tokenQuery.getResultList();
		
		return tokenList.get(0);
	}


	@Override
	public void uyeSil(String user) {
		
		Session session = sessionFactory.getCurrentSession();
		System.out.println("kullanıcı adı = "+ user);
		
		Query queryMusteri = session.createQuery("delete from Musteri where email=:email");
		queryMusteri.setParameter("email", user);
		queryMusteri.executeUpdate();
		
		Query queryUsers = session.createSQLQuery("delete from users where username=?");
		queryUsers.setString(0, user);
		queryUsers.executeUpdate();
		
		Query queryAuthority = session.createSQLQuery("delete from authorities where username=?");
		queryAuthority.setString(0, user);
		queryAuthority.executeUpdate();
		
		Query queryToken = session.createQuery("delete from VerificationToken where email=:email");
		queryToken.setParameter("email", user);
		queryToken.executeUpdate();
		
		
	}


	@Override
	public void setYeniSifre(String user, String yeniSifre) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("update Musteri set sifre=:yeniSifre, sifre_kontrol=:yeniSifre where email=:user");
		query.setParameter("yeniSifre", yeniSifre);
		//query.setParameter("sifre_kontrol", yeniSifre);
		query.setParameter("user", user);
		query.executeUpdate();
	}

	

}
