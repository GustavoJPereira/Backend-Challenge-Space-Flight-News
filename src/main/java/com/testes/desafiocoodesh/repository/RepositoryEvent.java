package com.testes.desafiocoodesh.repository;

import com.testes.desafiocoodesh.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepositoryEvent extends JpaRepository<Event, Long> {

    @Query(value = "SELECT `event`.id, `event`.provider FROM article_event INNER JOIN `event` ON `event`.id = article_event.eventId WHERE articleId='?1';", nativeQuery = true)
    List<Event> encontarEventos(Long articleId);
}
