package com.testes.desafiocoodesh.endpoint;

import com.testes.desafiocoodesh.entity.Article;
import com.testes.desafiocoodesh.repository.RepositoryArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/articles")
public class EndpointArticle {

    @Autowired
    private RepositoryArticle repositoryArticle;

    @GetMapping
    public Page<Article> ListarTodos(Pageable pageable) {
        return repositoryArticle.findAll(pageable);
    }

    @GetMapping(path = "/{id}")
    public Optional<Article> encontrarPorId(@PathVariable("id") Long id) {
        return repositoryArticle.findById(id);
    }

    @PostMapping
    public ResponseEntity adicionarArtigo(@RequestBody Article article) {
        if (article.getId() != null) {
        article.setId(null);
        Date dateTime = new Date();
        String dataHoraAtual = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dateTime);
        article.setPublishedAt(dataHoraAtual);
        }
        repositoryArticle.save(article);
        return new ResponseEntity(HttpStatus.CREATED);

    }

    @PutMapping(path = "/{id}")
    public ResponseEntity atualizaArtigo(@PathVariable("id") Long id, @RequestBody Article article) {
        if (repositoryArticle.findById(id).isPresent()) {
            article.setId(id);

            Date dateTime = new Date();
            String dataHoraAtual = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dateTime);
            article.setUpdateAt(dataHoraAtual);

            repositoryArticle.save(article);

            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity removerArtigo(@PathVariable("id") Long id) {
        if (repositoryArticle.findById(id).isPresent()) {
            repositoryArticle.deleteById(id);

            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
