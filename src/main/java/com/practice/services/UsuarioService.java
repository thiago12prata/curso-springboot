package com.practice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.entities.Usuario;
import com.practice.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	public List<Usuario> findAll() {
		return repository.findAll();
	}
	public Usuario findbyId(Long id) {
		Optional<Usuario> obj =  repository.findById(id);
		return obj.get();
	}
	public Usuario insert(Usuario obj) {
		return repository.save(obj);
	}
	public void delete(Long id) {
		repository.deleteById(id);
	}
	public Usuario update(Long id, Usuario obj) {
		Usuario entity = repository.getOne(id);
		atualizarDados(entity, obj);
		return repository.save(entity);
	}
	private void atualizarDados(Usuario entity, Usuario obj) {
		entity.setNome(obj.getNome());		
		entity.setEmail(obj.getEmail());		
		entity.setTelefone(obj.getTelefone());				
	}
}
