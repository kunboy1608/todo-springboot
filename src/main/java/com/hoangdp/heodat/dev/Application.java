package com.hoangdp.heodat.dev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.hoangdp.heodat.dev.domain.Address;
import com.hoangdp.heodat.dev.domain.Person;
import com.hoangdp.heodat.dev.repository.AddressRepository;
import com.hoangdp.heodat.dev.repository.PersonRepository;

@SpringBootApplication
@EnableConfigurationProperties
public class Application implements CommandLineRunner{

	@Autowired
	private PersonRepository  personRepository;

	@Autowired
	private AddressRepository addressRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Person person = Person.builder().name("phu").build();
		personRepository.save(person);

		Address address = Address.builder().city("HCM").person(person).build();

		addressRepository.save(address);
	}
}
