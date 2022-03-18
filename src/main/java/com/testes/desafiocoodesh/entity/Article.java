package com.testes.desafiocoodesh.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean featured;
    private String title;
    private String url;

    @Column(name = "imageurl")
    private String imageUrl;

    @Column(name = "newssite")
    private String newsSite;

    private String summary;

    @Column(name = "publishedat")
    private String publishedAt;

    @Column(name = "updateat")
    private String updateAt;

    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable(name = "article_event", joinColumns = @JoinColumn(name = "articleId", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "eventId", referencedColumnName = "id"))
    private List<Event> events;

    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable(name = "article_launch", joinColumns = @JoinColumn(name = "articleId", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "launchId", referencedColumnName = "id"))
    private List<Launch> launchs;

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

    public String getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<Launch> getLaunchs() {
        return launchs;
    }

    public void setLaunchs(List<Launch> launchs) {
        this.launchs = launchs;
    }
}
