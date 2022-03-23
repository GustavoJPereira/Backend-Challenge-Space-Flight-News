package com.testes.desafiocoodesh.entity;

import javax.persistence.*;

@Entity
public class Event {

    @Id
    private Long id;

    @Column(length = 30)
    private String provider;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }
}
