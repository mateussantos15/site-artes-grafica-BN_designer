package com.bndesigner.service.usuario;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bndesigner.domain.entity.usuario.Usuario;
import com.bndesigner.domain.exception.usuario.EmailJaCadastradoException;
import com.bndesigner.domain.exception.usuario.UsuarioNaoEncontradoException;
import com.bndesigner.repository.usuario.UsuarioRepository;

@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {
	
	@Mock
	private UsuarioRepository usuarioRepository;
	
	@InjectMocks
	private UsuarioService usuarioService;
	
	@Test
	void deveCriarUsaurioComSucesso() {
		Usuario usuario = Usuario.builder()
				.nome("Mateus")
				.email("mateus@santos.com")
				.build();
		
		when(usuarioRepository.save(any(Usuario.class)))
				.thenReturn(usuario);
		
		Usuario salvo = usuarioService.criar(usuario);
		
		assertNotNull(salvo);
		assertEquals("Mateus", salvo.getNome());
		verify(usuarioRepository).save(usuario);
	}
	
	@Test
	void deveLancarExcecaoQuandoUsuarioNaoExistir() {
		when(usuarioRepository.findById(1L)).
				thenReturn(Optional.empty());
		
		assertThrows(IllegalArgumentException.class, 
				() -> usuarioService.buscarPorId(1L));
	}
	
	@Test
	void deveLancarExcecaoQuandoEmailJaExistir() {
	    Usuario usuario = Usuario.builder()
	            .email("teste@email.com")
	            .build();

	    when(usuarioRepository.existsByEmail("teste@email.com"))
	            .thenReturn(true);

	    assertThrows(EmailJaCadastradoException.class,
	            () -> usuarioService.criar(usuario));

	    verify(usuarioRepository, never()).save(any());
	}

}
