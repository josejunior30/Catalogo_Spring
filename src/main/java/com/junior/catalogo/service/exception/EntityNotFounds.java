package com.junior.catalogo.service.exception;

public class EntityNotFounds extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public EntityNotFounds(String msg) {
		super(msg);
	}
}
