package com.enessimsek.urlshortener.urlshortener.dto;


public class UrlShortenerSaveRequestDto {

    private String shortener;

    private String url;

    public UrlShortenerSaveRequestDto() {
    }

    public UrlShortenerSaveRequestDto(String shortener, String url) {
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

    @Override
    public String toString() {
        return "UrlShortenerRequestDto{" +
                "shortener='" + shortener + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
