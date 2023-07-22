package com.hoangdp.heodat.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hoangdp.heodat.dev.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
