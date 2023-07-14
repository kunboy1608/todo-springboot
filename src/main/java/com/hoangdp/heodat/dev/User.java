package com.hoangdp.heodat.dev;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "user")
@Entity
@Data
public class User implements Serializable{
    private static final long serialVersionUID = 297553281792804396L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "hp")
    private int hp;

    @Column(name = "stamina")
    private int stamina;

    @Column(name = "atk")
    private int atk;

    @Column(name = "def")
    private int def;

    @Column(name = "agi")
    private int agi;

    
    
}
