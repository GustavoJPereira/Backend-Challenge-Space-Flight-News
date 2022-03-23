package com.testes.desafiocoodesh.endpoint;

import com.testes.desafiocoodesh.repository.RepositoryUltimoIdSpacefly;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Hidden
@RestController
@RequestMapping("/articles/ultimoid")
public class EndpointUltimoIdSpacefly {

    @Autowired
    RepositoryUltimoIdSpacefly repositoryUltimoIdSpacefly;

    @GetMapping
    public Long UltimoId() {
        return repositoryUltimoIdSpacefly.findUltimo().getUltimo();
    }

    @PostMapping
    public void atualizarUltimo(@RequestBody Long id) {
        repositoryUltimoIdSpacefly.atualizarUltimo(id);
    }
}
