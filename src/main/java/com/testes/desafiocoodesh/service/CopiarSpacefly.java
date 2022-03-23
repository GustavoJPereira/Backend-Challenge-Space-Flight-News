package com.testes.desafiocoodesh.service;

import com.testes.desafiocoodesh.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class CopiarSpacefly {
    private RestTemplate restTemplate = new RestTemplate();

    ConsumerApiSpaceFly consumerApiSpaceFly = new ConsumerApiSpaceFly();

    @Autowired
    CompararRespostaSpaceflyEArmazenarNoBanco adicionarEComparar = new CompararRespostaSpaceflyEArmazenarNoBanco();

    private String urlAplicacao = "http://localhost:8080/articles";

    @Autowired
    CompararRespostaSpaceflyEArmazenarNoBanco comparar = new CompararRespostaSpaceflyEArmazenarNoBanco();

    //Copia os novos dados da API SpaceFly para esta API através de um loop.
    public void copiarSpacefly() {

        if (comparar.verificarUltimoIdDoBanco()) {
            Long ultimoIdDoBanco = restTemplate.getForObject(urlAplicacao + "/ultimoid", Long.class);

            Long ultimoIdSpacefly = consumerApiSpaceFly.consumerAll().get(0).getId();

            while (ultimoIdSpacefly > ultimoIdDoBanco) {
                Article article = consumerApiSpaceFly.consumer(ultimoIdDoBanco + 1);
                if (article != null) {
                    adicionarEComparar.adicionarAoBanco(article);
                }

                ultimoIdDoBanco ++;
                restTemplate.postForObject(urlAplicacao + "/ultimoid" ,ultimoIdDoBanco , Long.class);
            }
        }
    }
}