package com.testes.desafiocoodesh.cron;

import com.testes.desafiocoodesh.repository.RepositoryUltimoIdSpacefly;
import com.testes.desafiocoodesh.service.CopiarSpacefly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CopiaNovosDadosDaSpacefly {

    CopiarSpacefly copiarSpacefly = new CopiarSpacefly();

    @Autowired
    RepositoryUltimoIdSpacefly repositoryUltimoIdSpacefly;

    //Cron para copiar novos conteúdos da SpaceFly API todo dia as 9 horas da manhã
    @Scheduled(cron = "0 0 9 * * ?") // * * 9 ? * * *
    public void CopiarDados() {
        if (!repositoryUltimoIdSpacefly.findById(1L).isPresent()){
            repositoryUltimoIdSpacefly.iniciarBanco();
        }
        copiarSpacefly.copiarSpacefly();
    }
}
