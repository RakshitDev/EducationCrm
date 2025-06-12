package com.sp.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.main.entities.User;
import com.sp.main.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	//handle register of user ---second-code
	public void registerUserService(User user) {
		userRepository.save(user);
		
	} 
	
	//Handle Login of User
	public boolean loginUserService(String email,String password) {
		User user = userRepository.findByEmail(email);
		if(user!=null) {
			return user.getPassword().equals(password);
		}
		else {
			return false;
		}
		
	}

}

////handle register of user ---first code
//	public boolean registerUserService(User user) {
//		try {
//			userRepository.save(user);
//			return true;
//		}catch (Exception e) {
//			e.printStackTrace();
//			return false;
//		}
//		
//	} 
