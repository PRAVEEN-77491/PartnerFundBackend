package com.PartnersFunds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class PartnersFundApplication {

	public static void main(String[] args) {
		SpringApplication.run(PartnersFundApplication.class, args);
	}
	 
}
