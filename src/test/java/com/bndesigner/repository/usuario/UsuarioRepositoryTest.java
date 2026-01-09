package com.bndesigner.repository.usuario;

import static org.assertj.core.api.Assertions.assertThat;

import com.bndesigner.domain.entity.usuario.Usuario;
import com.bndesigner.domain.enums.usuario.TipoUsuario;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
@ActiveProfiles("test")
class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    @DisplayName("Deve salvar e buscar usuário por email")
    void deveSalvarEConsultarUsuarioPorEmail() {
        Usuario usuario = Usuario.builder()
        		.nome("Mateus")
        		.sobrenome("Santos")
        		.email("mateus@email.com")
        		.senha("hash_da_senha")
        		.tipoUsuario(TipoUsuario.CLIENTE)
        		.build();

        usuarioRepository.save(usuario);

        var resultado = usuarioRepository.findByEmail("mateus@email.com");

        assertThat(resultado).isPresent();
        assertThat(resultado.get().getNome()).isEqualTo("Mateus");
    }

    @Test
    @DisplayName("Deve verificar existência de usuário por email")
    void deveRetornarTrueQuandoEmailExistir() {
    	 Usuario usuario = Usuario.builder()
         		.nome("Mateus")
         		.email("mateus@email.com")
         		.senha("hash_da_senha")
         		.tipoUsuario(TipoUsuario.CLIENTE)
         		.build();

        usuarioRepository.save(usuario);

        boolean existe = usuarioRepository.existsByEmail("admin@email.com");

        assertThat(existe).isTrue();
    }
}
