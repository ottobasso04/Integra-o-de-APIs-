package org.example.services;

import org.example.models.Usuario;
import org.example.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario save(Usuario usuario) {return usuarioRepository.save(usuario);}
    public List<Usuario> findAll() {return usuarioRepository.findAll();}

    public Usuario findById(String id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chave de identificação não encontrada"));
    }
}
