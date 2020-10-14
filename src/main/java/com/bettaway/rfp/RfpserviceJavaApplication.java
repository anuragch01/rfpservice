package com.bettaway.rfp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RfpserviceJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RfpserviceJavaApplication.class, args);
	}

}
