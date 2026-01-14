package com.bndesigner.dto.request.usuario;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioUpdateRequest {
	
	@NotBlank
	private String nome;
}
