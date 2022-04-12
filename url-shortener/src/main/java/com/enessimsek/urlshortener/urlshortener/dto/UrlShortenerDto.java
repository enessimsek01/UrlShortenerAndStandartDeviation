package com.enessimsek.urlshortener.urlshortener.dto;


public class UrlShortenerDto {

    private Long id;

    private String shortener;

    private String url;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "UrlShortenerDto{" +
                "id=" + id +
                ", shortener='" + shortener + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
