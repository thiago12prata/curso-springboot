package com.practice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.entities.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
