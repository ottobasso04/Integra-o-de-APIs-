package org.example.services;

import org.example.clients.UsuarioClient;
import org.example.models.Planilha;
import org.example.models.Usuario;
import org.example.repositories.PlanilhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanilhaService {

    @Autowired
    private PlanilhaRepository planilhaRepository;

    @Autowired
    private UsuarioClient usuarioClient;

    public Planilha save(Planilha planilha){

        String idUsuario = planilha.getUsuarioCadastrado().getId();
        Usuario usuarioReal = usuarioClient.buscarUsuarioPorId(idUsuario);

        if (usuarioReal == null){
            throw new RuntimeException("Usuário não encontrado.");
        }

        planilha.setUsuarioCadastrado(usuarioReal);

        return planilhaRepository.save(planilha);
    }
    public List<Planilha> findAll(){return planilhaRepository.findAll();}
}
