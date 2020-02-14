package com.projects.springboot.app.config.exception;

@SuppressWarnings("serial")
public class NotFoundException extends RuntimeException {

	public NotFoundException() {
		super("Not found");
	}

	public NotFoundException(String message) {
		super("Not found: " + message);
	}

}
