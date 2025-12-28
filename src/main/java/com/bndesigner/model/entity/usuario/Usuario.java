package com.bndesigner.model.entity.usuario;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUsuario;

	@Column(nullable = false, length = 50)
	private String nome;

	private String sobrenome;

	@Column(nullable = false, unique = true, length = 100)
	private String email;

	@Column(nullable = false, length = 255)
	private String senha;

	@Column(nullable = false, updatable = false)
	private LocalDateTime dataCadastro = LocalDateTime.now();

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TipoUsuario tipoUsuario;

	public enum TipoUsuario {
		CLIENTE, ADMIN
	}

}
