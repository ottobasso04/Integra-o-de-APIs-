package org.example.clients;

import org.example.models.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "usuario-client", url = "http://localhost:8081")
public interface UsuarioClient {

    @GetMapping("Buscar-usuarios-por-Id/{id}")
    Usuario buscarUsuarioPorId(@PathVariable("id") String id);
}
