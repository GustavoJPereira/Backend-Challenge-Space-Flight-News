package com.testes.desafiocoodesh.repository;

import com.testes.desafiocoodesh.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryArticle extends JpaRepository<Article, Long> {

    //Retorna o registro com maior Id do banco
    @Query(value = "SELECT * FROM article order by id desc Limit 1", nativeQuery = true)
    public Article retornarMaiorId();
}
