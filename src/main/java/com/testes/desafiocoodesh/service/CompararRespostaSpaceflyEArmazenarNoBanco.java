package com.testes.desafiocoodesh.service;

import com.testes.desafiocoodesh.entity.Article;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class CompararRespostaSpaceflyEArmazenarNoBanco {

    private String urlAplicacao = "http://localhost:8080/articles";

    private RestTemplate restTemplate = new RestTemplate();

    ConsumerApiSpaceFly consumerApiSpaceFly = new ConsumerApiSpaceFly();

    //Recebe um artigo e o adiciona ao banco
    public void adicionarAoBanco(Article article) {

            HttpHeaders headers = new HttpHeaders();
            headers.set("Space-fly", article.getId().toString());
            HttpEntity<Article> request = new HttpEntity<>(article, headers);

            restTemplate.postForObject(urlAplicacao, request, Article.class);
    }

    //Compara se o ultimo id da spacefly foi copiado para o banco
    public Boolean verificarUltimoIdDoBanco() {

        Long ultimoIdDoBanco = restTemplate.getForObject(urlAplicacao + "/ultimoid", Long.class);

        Long ultimoIdSpacefly = consumerApiSpaceFly.consumerAll().get(0).getId();

        return ultimoIdSpacefly > ultimoIdDoBanco;
    }
}
