package com.partnersFunds.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.partnersFunds.Entities.UserEntity;
import com.partnersFunds.Repo.UserRepo;
import com.partnersFunds.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepo userRepo;
	
	private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	@Override
	public UserEntity insertNewUser(UserEntity user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepo.save(user);
	}

}
