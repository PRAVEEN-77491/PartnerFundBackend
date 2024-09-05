package com.PartnersFunds.Controllers;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.PartnersFunds.DTO.UserCredentialsDTO;
import com.PartnersFunds.Entities.UserEntity;
import com.PartnersFunds.Repo.UserRepo;
import com.PartnersFunds.service.UserService;
import com.PartnersFunds.serviceImpl.UserDetailsServiceImpl;
import com.PartnersFunds.utils.JwtUtil;

@RestController
public class AuthenticationController {

	@Autowired
	UserRepo userRepo;
	
	@Autowired
	JwtUtil jwtUtil;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserDetailsServiceImpl userDetailsServiceImpl;

	@PostMapping("/signup")
	@ResponseBody
	public UserEntity signup(@RequestBody UserEntity user) {
		System.out.println(user);
		return userService.insertNewUser(user);
	}

	@PostMapping("/login")
	@ResponseBody
	public ResponseEntity<String> login(@RequestBody UserCredentialsDTO userCredentials) {
		System.out.println(userCredentials.toString());
		try {
			authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(userCredentials.getCiscoCecId(), userCredentials.getPassword()));
			
			UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(userCredentials.getCiscoCecId());
			
//			System.out.println("userDetails ====> " + userDetails);
            // Convert authorities to a String[]
            String[] roles = userDetails.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .toArray(String[]::new);
            
			String jwt = jwtUtil.generateToken(userDetails.getUsername(), roles);
			return new ResponseEntity<>(jwt, HttpStatus.OK);
		} catch (Exception e) {
//			System.out.println("Login Failed");
			return new ResponseEntity<>("Incorrect Username or Password", HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/updateRole")
	public ResponseEntity<?> updateRole(@RequestHeader("Authorization") String token, @RequestParam("role") String[] newRole) {
	    
		String tokenWithoutBearer = token.substring(7);
	    	    
	    String username = jwtUtil.extractUsername(tokenWithoutBearer);
	    
	    UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(username);
	    
	    Collection<? extends GrantedAuthority> currentRoles = userDetails.getAuthorities();
	    
	    Set<String> currentRoleNames = currentRoles.stream()
	            .map(GrantedAuthority::getAuthority)
	            .collect(Collectors.toSet());
	    
	    boolean roleExists = currentRoleNames.contains(newRole[0]);
	    
	    if (!roleExists) {
	        return ResponseEntity.badRequest().body("The role does not exist in the user's current roles.");
	    }

	    String newToken = jwtUtil.generateToken(userDetails.getUsername(), newRole);

	    return ResponseEntity.ok().body("New token generated with updated role: " + newToken);
	}

}
