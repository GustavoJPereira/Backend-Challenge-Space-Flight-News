package com.testes.desafiocoodesh.entity;

import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.util.List;

@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // O uso de GeneratedValue impede o usuário de decidir o
    // valor no banco, impedindo a cópia dos dados da SpaceFly, mas a falta dele impede a organização de novos itens
    // adicionados. Decidi por deixa-lo presente. Por este motivo, o id dos artigos não será o mesmo no banco de dados
    // desta API e da spacefly.
    private Long id;
    private Boolean featured;
    private String title;
    private String url;

    @Column(name = "imageurl")
    private String imageUrl;

    @Column(name = "newssite",length = 60)
    private String newsSite;

    //Testes mostraram que alguns artigos específicos passam de mil caracteres. Por conta destes casos a coluna é uma
    //varchar de 1500 caracteres.
    @Column(length = 1500)
    private String summary;

    //Todo perceba que o nome correto para coluna é updateAt mas deveria ser updatedAt

    @Column(name = "publishedat", length = 26)
    private String publishedAt;

    @Column(name = "updatedat",  length = 26)
    private String updatedAt;

    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable(name = "article_event", joinColumns = @JoinColumn(name = "articleId", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "eventId", referencedColumnName = "id"))
    private List<Event> events;

    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable(name = "article_launch", joinColumns = @JoinColumn(name = "articleId", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "launchId", referencedColumnName = "id"))
    private List<Launch> launches;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getFeatured() {
        return featured;
    }

    public void setFeatured(Boolean featured) {
        this.featured = featured;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getNewsSite() {
        return newsSite;
    }

    public void setNewsSite(String newsSite) {
        this.newsSite = newsSite;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<Launch> getLaunches() {
        return launches;
    }

    public void setLaunches(List<Launch> launches) {
        this.launches = launches;
    }
}
