package com.library.app.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.library.app.model.User;
import com.library.app.repository.UserRepository;

public class CustomUsernamePasswordAuthenticationFilter extends  UsernamePasswordAuthenticationFilter {
//	@Resource(name = "userRepository")
	@Autowired
	private UserRepository userRepository;
	
	
	public CustomUsernamePasswordAuthenticationFilter(){
		super();
	}
	
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response){
	
 		try{
			
			Authentication auth = super.attemptAuthentication(request,response);
			String email = obtainUsername(request);
			User user = userRepository.findByEmail(email);
	        String remoteAddress = request.getRemoteAddr();
	        

			canLoginChecker(user);
			
			return auth;
		}catch (BadCredentialsException e) {
			
			//*************Kullanıcı Hatalı Giriş Kaydı**************
			String kullaniciAdi = obtainUsername(request);
			//***********************************************************
			throw new BadCredentialsException("1"); //login.jsp de excepiton numberına göre, açıklama eşleşmesi yapılıyor (Yanlış Kullanıcı Adı veya parola)
		}catch (LockedException e) {
			throw new LockedException("2"); 		//login.jsp de excepiton numberına göre, açıklama eşleşmesi yapılıyor (Hesabı Kilitli Kullanıcı)
		}catch (DisabledException e) {
			throw new BadCredentialsException("4"); //login.jsp de excepiton numberına göre, açıklama eşleşmesi yapılıyor (Yasakli Kullanici)
		}
	}
 

	public void canLoginChecker(User kullanici) {
			
		if(kullanici == null){
			throw new BadCredentialsException("1");
		}
	}


	
}
