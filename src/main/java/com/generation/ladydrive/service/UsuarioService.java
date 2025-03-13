package com.generation.ladydrive.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.generation.ladydrive.model.Usuario;
import com.generation.ladydrive.repository.UsuarioRepository;

//Aplicativo de Carona Compartilhadas: Se o passeiro for do sexo feminino
@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
			
	public Optional<Usuario> cadastrarUsuario(Usuario usuario) {
				
				if(!usuario.getSexo().equalsIgnoreCase("feminino")) 
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Este App é exclusivo para mulheres!", null);
				
				return Optional.of(usuarioRepository.save(usuario));
  }
}
