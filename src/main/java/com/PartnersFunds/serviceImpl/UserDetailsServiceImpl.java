package com.PartnersFunds.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.PartnersFunds.Entities.UserEntity;
import com.PartnersFunds.Repo.UserRepo;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String ciscoCecId) throws UsernameNotFoundException {
		UserEntity user = userRepo.findByciscoCecId(ciscoCecId).get();//.orElseThrow(() -> new UsernameNotFoundException("User does not exist"));
		
		String[] rolesArray = {"ADMIN"};
		
		UserDetails userDetails = User.builder().username(user.getCiscoCecId()).password(user.getPassword())
				.roles(rolesArray).build();
		
		return userDetails;
	}

}
