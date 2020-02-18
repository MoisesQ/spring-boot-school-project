package com.projects.springboot.app.config.exception;

public class BadRequestException extends RuntimeException {

	public BadRequestException() {
		super("Bad Request");
	}

	public BadRequestException(String message) {
		super("Bad Request: " + message);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
