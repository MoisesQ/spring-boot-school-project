package com.projects.springboot.app.config.exception;

@SuppressWarnings("serial")
public class BadRequestException extends RuntimeException {

	public BadRequestException() {
		super("Bad Request");
	}

	public BadRequestException(String message) {
		super("Bad Request: " + message);
	}

}
