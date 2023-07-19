package com.hoangdp.heodat.dev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties
public class Application {

	@Autowired
	MyHouse myHouse;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);				
	}

	@Bean
	CommandLineRunner run() {
		return args -> {
			System.out.println(Thread.currentThread().getName() + ": Phu đi tới cửa nhà !!!");
			System.out.println(Thread.currentThread().getName() + ": => Phu bấm chuông và khai báo họ tên!");
			// gõ cửa
			myHouse.rangDoorbellBy("Phu");
			System.out.println(Thread.currentThread().getName() + ": Phu quay lưng bỏ đi");
		};
	}
}
