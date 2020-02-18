package com.projects.springboot.app.config.exception;

public class NotFoundException extends RuntimeException {

	public NotFoundException() {
		super("Not found");
	}

	public NotFoundException(String message) {
		super("Not found: " + message);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
