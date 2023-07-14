package com.hoangdp.heodat.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
		// var context = SpringApplication.run(Application.class, args);
		// UserRepository userRepository = context.getBean(UserRepository.class);

		// userRepository.findAll().forEach(System.out::println);

		// User user = userRepository.save(new User());
		// System.out.println("User vua luu id=" + user.getId());
		// Long userId = user.getId();
		// user.setAgi(100);
		// userRepository.save(user);

		// User user2 = userRepository.findById(userId).get();
		// System.out.println("User:" + user.toString());
		// System.out.println("User2: "+user2.toString());

		// userRepository.delete(user);

		// User user3 = userRepository.findById(userId).orElse(null);
		// System.out.println("User3 : "+ user3);

		// System.out.println("TIm uer voi Agi trong khoang 23 -30");
		// userRepository.findAllByAgiBetween(25, 30).forEach(System.out::println);

		// System.out.println("Tim user voi Agi lon hon 97");
		// userRepository.findAllByAgiGreaterThan(97).forEach(System.out::println);

		// System.out.println("TIm tat ca User voi atk =74");
		// userRepository.findAllByAtk(74).forEach(System.out::println);

		// System.out.println("Tim user voi def = 49");
		// User user4= userRepository.findUserByDefQuery(49);
		// System.out.println("User 4:" + user4);
	}

}
