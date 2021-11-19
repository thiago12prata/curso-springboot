package com.practice.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.practice.entities.Usuario;
import com.practice.repositories.UsuarioRepository;
import com.practice.services.exceptions.DataBaseException;
import com.practice.services.exceptions.RecursoNotFoudException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	public List<Usuario> findAll() {
		return repository.findAll();
	}
	public Usuario findbyId(Long id) {
		Optional<Usuario> obj =  repository.findById(id);
		return obj.orElseThrow(() -> new RecursoNotFoudException(id));
	}
	public Usuario insert(Usuario obj) {
		return repository.save(obj);
	}
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} 
		catch (EmptyResultDataAccessException e) {
			throw new RecursoNotFoudException(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
		
	}
	public Usuario update(Long id, Usuario obj) {
		try {
			Usuario entity = repository.getOne(id);
			atualizarDados(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new RecursoNotFoudException(id);
		}

	}
	private void atualizarDados(Usuario entity, Usuario obj) {
		entity.setNome(obj.getNome());		
		entity.setEmail(obj.getEmail());		
		entity.setTelefone(obj.getTelefone());				
	}
}
