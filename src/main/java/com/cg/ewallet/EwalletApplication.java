package com.cg.ewallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
@EnableDiscoveryClient
@SpringBootApplication
public class EwalletApplication {

	public static void main(String[] args) {
		SpringApplication.run(EwalletApplication.class, args);
	}
	
	
	@LoadBalanced 
	@Bean 
	public RestTemplate getRestTemplate()
	{ 
		return new RestTemplate();
	}
}
