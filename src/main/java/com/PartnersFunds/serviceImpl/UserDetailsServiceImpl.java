package com.PartnersFunds.serviceImpl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public UserDetails loadUserByUsername(String ciscoCecId) throws UsernameNotFoundException {
		UserEntity user = userRepo.findByciscoCecId(ciscoCecId).get();//.orElseThrow(() -> new UsernameNotFoundException("User does not exist"));

		String sql = "SELECT name FROM xxpf_role_master WHERE role_id IN (select role_id from xxpf_fund_roles where fund_role_id in (SELECT fund_role_id FROM xxpf_user_fund_roles WHERE user_id = (SELECT user_id FROM xxpf_users WHERE cisco_cec_id = ?)))";
		List<Map<String, Object>> queryResult = jdbcTemplate.queryForList(sql,user.getCiscoCecId());
        // Convert queryResult to List<String>
        List<String> roleNames = queryResult.stream()
                .map(row -> (String) row.get("NAME"))
                .collect(Collectors.toList());
        
		System.out.println("roleNames : " + roleNames);
		
		String[] rolesArray = roleNames.toArray(new String[0]);
		
		System.out.println("rolesArray : " + rolesArray);

		UserDetails userDetails = User.builder().username(user.getCiscoCecId()).password(user.getPassword())
				.roles(rolesArray).build();
		
		return userDetails;
	}

}
