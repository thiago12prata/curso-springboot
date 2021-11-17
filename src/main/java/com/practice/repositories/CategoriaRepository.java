package com.practice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.entities.Categoria;


public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
