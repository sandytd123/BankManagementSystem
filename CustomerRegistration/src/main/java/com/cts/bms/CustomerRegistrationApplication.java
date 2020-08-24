package com.cts.bms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@SpringBootApplication
@EnableHystrix
@EnableZuulProxy
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableHystrixDashboard
public class CustomerRegistrationApplication {
	
	@Bean
	@LoadBalanced
	public RestTemplate getrestTemplate(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(CustomerRegistrationApplication.class, args);
	}

}
