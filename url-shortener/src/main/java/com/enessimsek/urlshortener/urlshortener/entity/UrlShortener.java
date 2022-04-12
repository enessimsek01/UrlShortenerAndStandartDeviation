package com.enessimsek.urlshortener.urlshortener.entity;

import javax.persistence.*;

@Entity
public class UrlShortener {
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false,unique = true)
    private String shortener;

    @Column(nullable = false)
    private String url;


    public UrlShortener() {
    }

    public UrlShortener(String shortener, String url) {
        this.shortener = shortener;
        this.url = url;
    }


    public String getShortener() {
        return shortener;
    }

    public void setShortener(String shortener) {
        this.shortener = shortener;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UrlShortener{" +
                "id=" + id +
                ", shortener='" + shortener + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
