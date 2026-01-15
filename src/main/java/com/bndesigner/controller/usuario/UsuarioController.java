package com.bndesigner.controller.usuario;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bndesigner.dto.request.usuario.UsuarioCreateRequest;
import com.bndesigner.dto.response.usuario.UsuarioResponse;
import com.bndesigner.mapper.usuario.UsuarioMapper;
import com.bndesigner.service.usuario.UsuarioService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {
	
	private final UsuarioService usuarioService;
	private final UsuarioMapper usuarioMapper;
	
	@PostMapping
	public ResponseEntity<UsuarioResponse> criar(
			@RequestBody @Valid UsuarioCreateRequest request
	) {
		var usuario = usuarioMapper.toEntity(request);
		var salvo = usuarioService.criar(usuario);
		
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(usuarioMapper.toResponse(salvo));
	}
}
