package com.testes.desafiocoodesh.entity;


import javax.persistence.Entity;
import javax.persistence.Id;

// está tabela é necessário para medir quais artigos já foram adicionados ao banco, já que foi impossível manter os
//mesmos IDs da Spacefly sem impossibilitar a entrada de novos artigos que não venham de lá.

@Entity
public class UltimoIdSpacefly {

    @Id
    private Long id;
    private Long ultimo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUltimo() {
        return ultimo;
    }

    public void setUltimo(Long ultimo) {
        this.ultimo = ultimo;
    }
}
