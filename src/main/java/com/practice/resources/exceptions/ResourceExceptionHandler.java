package com.practice.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.practice.services.exceptions.DataBaseException;
import com.practice.services.exceptions.RecursoNotFoudException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(RecursoNotFoudException.class)
	public ResponseEntity<StandardError> recursoNotFoud(RecursoNotFoudException e, HttpServletRequest request) {
		String erro = "Recurso não encontrado";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), erro, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<StandardError> Exception(Exception e, HttpServletRequest request) {
		String erro = "Erro interno do servidor";
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		StandardError err = new StandardError(Instant.now(), status.value(), erro, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	@ExceptionHandler(DataBaseException.class)
	public ResponseEntity<StandardError> DataBase(DataBaseException e, HttpServletRequest request) {
		String erro = "Erro do Banco de dados";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(), status.value(), erro, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
