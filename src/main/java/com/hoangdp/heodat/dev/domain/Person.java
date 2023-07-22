package com.hoangdp.heodat.dev.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Person {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
}
