package com.pedro.lab4eurekaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Lab4EurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lab4EurekaClientApplication.class, args);
	}

}
