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
    public ResponseEntity<Optional<Article>> encontrarPorId(@PathVariable("id") Long id) {
        if (repositoryArticle.findById(id).isPresent()) {
            return new ResponseEntity<>(repositoryArticle.findById(id), HttpStatus.OK) ;
        } else  {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    //Se o id for somente setado para null com o intuito de impedir que ele atualize um item do banco isso causará um
    // problema que impede o relacioonamento dele com os evests e com os lanches. Isso pode ser contornado inserindo um
    //número maior no id do que os presentes no banco.
    @PostMapping
    public ResponseEntity adicionarArtigo(@RequestBody Article article) {

        //Pega o maior id do banco e adiciona um para ter o id correto e sobreescrever nenhum outro registro
        article.setId(repositoryArticle.retornarMaiorId().getId() + 1);

        if (article.getPublishedAt() == null) {
            Date dateTime = new Date();
            String dataHoraAtual = new SimpleDateFormat("yyyy-MM-dd").format(dateTime) +
                    "T" + new SimpleDateFormat("HH:mm:ss:SSS").format(dateTime) +"Z";
            article.setPublishedAt(dataHoraAtual);
        }
        if (article.getUpdatedAt() == null) {
            Date dateTime = new Date();
            String dataHoraAtual = new SimpleDateFormat("yyyy-MM-dd").format(dateTime) +
                    "T" + new SimpleDateFormat("HH:mm:ss:SSS").format(dateTime) +"Z";
            article.setUpdatedAt(dataHoraAtual);
        }

        repositoryArticle.save(article);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity atualizaArtigo(@PathVariable("id") Long id, @RequestBody Article article) {
        if (repositoryArticle.findById(id).isPresent()) {
            article.setId(id);

            article.setPublishedAt(repositoryArticle.findById(id).get().getPublishedAt());

            Date dateTime = new Date();
            String dataHoraAtual = new SimpleDateFormat("yyyy-MM-dd").format(dateTime) +
                    "T" + new SimpleDateFormat("HH:mm:ss:SSS").format(dateTime) +"Z";
            article.setUpdatedAt(dataHoraAtual);

            repositoryArticle.save(article);

            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity removerArtigo(@PathVariable("id") Long id) {
        if (repositoryArticle.findById(id).isPresent()) {
            repositoryArticle.deleteById(id);

            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}