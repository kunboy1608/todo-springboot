package com.hoangdp.heodat.dev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.hoangdp.heodat.dev.config.AppProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	AppProperties lodaAppProperties;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Global variable:");
		System.out.println("\t Email: " + lodaAppProperties.getEmail());
		System.out.println("\t GA ID: " + lodaAppProperties.getGoogleAnalyticsId());
		System.out.println("\t Authors: " + lodaAppProperties.getAuthors());
		System.out.println("\t Example Map: " + lodaAppProperties.getExampleMap());
	}
}
