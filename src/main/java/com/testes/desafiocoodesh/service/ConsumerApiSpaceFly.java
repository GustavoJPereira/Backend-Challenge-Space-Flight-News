package com.testes.desafiocoodesh.service;

import com.testes.desafiocoodesh.entity.Article;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ConsumerApiSpaceFly {

    RestTemplate restTemplate = new RestTemplate();

    //Faz a requisição de um único item para a API spacefly e retorna o artigo encontrado
    public Article consumer(Long id) {
        String url = "https://api.spaceflightnewsapi.net/v3/articles/" + id.toString() ; //o id para teste é 14325

        Article respostaDaApi;

        try {
            respostaDaApi = restTemplate.getForObject(url, Article.class);
        } catch (HttpClientErrorException e) {
            respostaDaApi = null;
        }

        return respostaDaApi;
    }

    //Retorno o artigo mais novo da SpaceFly API
    public List<Article> consumerAll() {
        String url = "https://api.spaceflightnewsapi.net/v3/articles?_limit=1";

        Article[] respostaDaApi = restTemplate.getForObject(url, Article[].class);
        List<Article> ListaDeArtigos =  new ArrayList<>(Arrays.asList(respostaDaApi));
        return ListaDeArtigos;
    }
}
