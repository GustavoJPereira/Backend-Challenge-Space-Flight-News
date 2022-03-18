package com.testes.desafiocoodesh.repository;

import com.testes.desafiocoodesh.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryArticle extends JpaRepository<Article, Long> {
}
