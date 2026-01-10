package com.bndesigner.service.usuario;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bndesigner.domain.entity.usuario.Usuario;
import com.bndesigner.domain.exception.usuario.EmailJaCadastradoException;
import com.bndesigner.domain.exception.usuario.UsuarioNaoEncontradoException;
import com.bndesigner.repository.usuario.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {
	
	private final UsuarioRepository usuarioRepository;
	
	@Transactional
	public Usuario criar(Usuario usuario) {
		if (usuarioRepository.existsByEmail(usuario.getEmail())) {
			throw new EmailJaCadastradoException(usuario.getEmail());
		}
		return usuarioRepository.save(usuario);
	}
	
	@Transactional(readOnly = true)
	public Usuario buscarPorId(Long id) {
		return usuarioRepository.findById(id)
				.orElseThrow(() -> new UsuarioNaoEncontradoException (id));
	}
	
	@Transactional(readOnly = true)
	public List<Usuario> listarTodos() {
		return usuarioRepository.findAll();
	}
	
	@Transactional
	public Usuario atualizar(Long id, Usuario usuarioAtualizado) {
		Usuario usuario = buscarPorId(id);
		usuario.setNome(usuarioAtualizado.getNome());
		usuario.setEmail(usuarioAtualizado.getEmail());
		return usuarioRepository.save(usuario);
	}
	
	@Transactional
	public void excluir(Long id) {
		Usuario usuario = buscarPorId(id);
		usuarioRepository.delete(usuario);
	}
}
