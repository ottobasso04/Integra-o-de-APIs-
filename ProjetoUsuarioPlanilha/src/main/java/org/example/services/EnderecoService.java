package org.example.services;

import org.example.models.Endereco;
import org.example.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco save(Endereco endereco) {return enderecoRepository.save(endereco);}
    public List<Endereco> findAll(){return enderecoRepository.findAll();}
}
