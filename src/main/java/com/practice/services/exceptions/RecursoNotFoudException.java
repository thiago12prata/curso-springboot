package com.practice.services.exceptions;

public class RecursoNotFoudException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public RecursoNotFoudException(Object id) {
		super("Não foi encontrado o recurso com a Id "+ id);
	}
}
