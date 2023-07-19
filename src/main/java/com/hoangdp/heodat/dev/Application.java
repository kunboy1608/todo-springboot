package com.hoangdp.heodat.dev;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;

import com.hoangdp.heodat.dev.User.UserType;

@SpringBootApplication
@EnableConfigurationProperties
public class Application {

	@Autowired
	MyHouse myHouse;

	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner run() {
		Specification<User> conditions = Specification
				.where(UserSpecification.hasIdIn(Arrays.asList(1L, 2L, 3l, 4L, 5L)))
				.and(UserSpecification.hasType(UserType.NORMAL)).or(UserSpecification.hasId(10L));
		userRepository.findAll(conditions).forEach(System.out::println);
		
		return args -> {
			System.out.println(Thread.currentThread().getName() + ": Phu đi tới cửa nhà !!!");
			System.out.println(Thread.currentThread().getName() + ": => Phu bấm chuông và khai báo họ tên!");
			// gõ cửa
			myHouse.rangDoorbellBy("Phu");
			System.out.println(Thread.currentThread().getName() + ": Phu quay lưng bỏ đi");
		};
	}
}
