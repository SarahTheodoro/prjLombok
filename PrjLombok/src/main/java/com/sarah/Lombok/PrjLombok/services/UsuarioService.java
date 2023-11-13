package com.sarah.Lombok.PrjLombok.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.sarah.Lombok.PrjLombok.entities.Usuario;
import com.sarah.Lombok.PrjLombok.repositories.UsuarioRepositorio;

public class UsuarioService {

	private final UsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	public UsuarioService(UsuarioRepositorio usuarioRepository) {
		this.usuarioRepositorio = usuarioRepository;
	}


	public Usuario saveUsuario(Usuario usuario) {
		return usuarioRepositorio.save(usuario);
	}


	public Usuario getUsuarioById(Long id) {
		return usuarioRepositorio.findById(id).orElse(null);
	}

	public List<Usuario> getAllusuario() {
		return usuarioRepositorio.findAll();
	}


	public void deleteUsuario(Long id) {
		usuarioRepositorio.deleteById(id);
	}
	
	public Usuario updateUsuario(Long id, Usuario novoUsuario) {
        Optional<Usuario> usuarioOptional = usuarioRepositorio.findById(id);
        if (usuarioOptional.isPresent()) {
        	Usuario usuarioExistente = usuarioOptional.get();
        	usuarioExistente.setNome(novoUsuario.getNome());
        	usuarioExistente.setEmail(novoUsuario.getEmail());          
            return usuarioRepositorio.save(usuarioExistente); 
        } else {
            return null; 
        }
    }


	
}
