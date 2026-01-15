package com.bndesigner.controller.usuario;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.bndesigner.dto.request.usuario.UsuarioCreateRequest;
import com.bndesigner.mapper.usuario.UsuarioMapper;
import com.bndesigner.service.usuario.UsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;


@WebMvcTest(UsuarioController.class)
public class UsuarioControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@MockitoBean
	private UsuarioService usuarioService;
	
	@MockitoBean
	private UsuarioMapper usuarioMapper;
	
	@Test
	void deveCriarUsuarioComSucesso () throws Exception {
		var request = new UsuarioCreateRequest();
		request.setNome("Marcos");
		request.setEmail("marcos@silva.com");
		request.setSenha("123");
		
		mockMvc.perform(post("/usuarios")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(request)))
		.andExpect(status().isCreated());
	}
}