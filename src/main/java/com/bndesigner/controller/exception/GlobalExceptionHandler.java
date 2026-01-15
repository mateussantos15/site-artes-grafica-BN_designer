package com.bndesigner.controller.exception;

import java.time.OffsetDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bndesigner.domain.exception.usuario.EmailJaCadastradoException;
import com.bndesigner.domain.exception.usuario.UsuarioNaoEncontradoException;

import lombok.experimental.var;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UsuarioNaoEncontradoException.class)
	public ResponseEntity<ApiError> handleUsuarioNaoEncontrado (
			UsuarioNaoEncontradoException ex
	) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new ApiError (
						404,
						"Usuário não Encontrado!",
						ex.getMessage(),
						OffsetDateTime.now()
				));		
	}
	
	@ExceptionHandler(EmailJaCadastradoException.class)
	public ResponseEntity<ApiError> handleEmailJaCadastrado (
			EmailJaCadastradoException ex
	) {
		return ResponseEntity.status(HttpStatus.CONFLICT)
				.body(new ApiError(
						409, 
						"E-mail já Cadastrado!", 
						ex.getMessage(), 
						OffsetDateTime.now()
				));
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ApiError> handleValidation (
			MethodArgumentNotValidException ex
	) {
		var message = ex.getBindingResult()
				.getFieldErrors()
				.stream()
				.map(e -> e.getField() + ": " + e.getDefaultMessage())
				.toList()
				.toString();
			
		return ResponseEntity.badRequest()
				.body(new ApiError(
						400, 
						"Error de Validação!", 
						message, 
						OffsetDateTime.now()
				));
	}
}
