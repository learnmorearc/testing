package com.arc.poc.work.account.grpsrt;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.arc.poc.work.account.grpsrt.config.AccountGrouping;
import com.arc.poc.work.account.grpsrt.model.AccountGroup;
import com.arc.poc.work.account.grpsrt.test.TransferActivityService;

@SpringBootApplication
@EnableConfigurationProperties({AccountGrouping.class})
public class AccountGroupingSortingApp {
	
	public static void main(String[] args) {
		SpringApplication.run(AccountGroupingSortingApp.class);
	}

	@Bean
	public CommandLineRunner demo(TransferActivityService transferActivityService) {
		return (args) -> {
			
			List<AccountGroup> list = transferActivityService.getAccounts();
			
		};
	}
}
