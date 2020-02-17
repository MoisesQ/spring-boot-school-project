package com.projects.springboot.app.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.projects.springboot.app.config.exception.BadRequestException;
import com.projects.springboot.app.config.exception.NotFoundException;


@RestControllerAdvice
public class ExceptionConfig {

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<String> notFoundException(Exception e) {

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<String> badRequestException(Exception e) {

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}

}