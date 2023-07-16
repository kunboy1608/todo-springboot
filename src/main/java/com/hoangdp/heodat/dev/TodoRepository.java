package com.hoangdp.heodat.dev;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long>{
    List<Todo> findAll();

    Todo findById(int id);
}
