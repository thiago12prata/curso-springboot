package com.practice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.entities.Categoria;
import com.practice.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;
	
	public List<Categoria> findAll() {
		return repository.findAll();
	}
	public Categoria findbyId(Long id) {
		Optional<Categoria> obj =  repository.findById(id);
		return obj.get();
	}
}
