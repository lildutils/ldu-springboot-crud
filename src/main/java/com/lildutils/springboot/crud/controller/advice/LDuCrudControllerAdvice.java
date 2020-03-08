package com.lildutils.springboot.crud.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.lildutils.springboot.crud.service.ex.LDuEntityAlreadyExistsException;
import com.lildutils.springboot.crud.service.ex.LDuEntityNotFoundException;

@ControllerAdvice
public class LDuCrudControllerAdvice extends ResponseEntityExceptionHandler
{
	@ExceptionHandler(LDuEntityNotFoundException.class)
	ResponseEntity<?> handleLDuEntityNotFoundException( LDuEntityNotFoundException e )
	{
		return super.handleExceptionInternal( e, e.getMessage(), null, HttpStatus.NOT_FOUND, null );
	}

	@ExceptionHandler(LDuEntityAlreadyExistsException.class)
	ResponseEntity<?> handleLDuEntityAlreadyExistsException( LDuEntityAlreadyExistsException e )
	{
		return super.handleExceptionInternal( e, e.getMessage(), null, HttpStatus.CONFLICT, null );
	}

}
