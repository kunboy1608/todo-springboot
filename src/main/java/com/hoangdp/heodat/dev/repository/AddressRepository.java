package com.hoangdp.heodat.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hoangdp.heodat.dev.domain.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
