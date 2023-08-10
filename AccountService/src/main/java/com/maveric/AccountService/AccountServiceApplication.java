package com.maveric.AccountService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
//@EnableDiscoveryClient
@SpringBootApplication
public class AccountServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(AccountServiceApplication.class, args);
	}
	@Bean
    public ModelMapper modelMapper(){
		return new ModelMapper();
	}
}
