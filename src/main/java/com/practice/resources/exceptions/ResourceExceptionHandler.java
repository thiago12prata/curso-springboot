package com.practice.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

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
}
