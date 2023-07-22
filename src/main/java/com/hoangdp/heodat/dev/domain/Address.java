package com.hoangdp.heodat.dev.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Data;

@Entity
@Builder
@Data
public class Address {
    @Id
    @GeneratedValue
    private Long id;

    private String city;
    private String province;

    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;
}
