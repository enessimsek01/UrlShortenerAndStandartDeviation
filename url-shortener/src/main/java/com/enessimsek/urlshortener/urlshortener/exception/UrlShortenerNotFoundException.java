package com.enessimsek.urlshortener.urlshortener.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UrlShortenerNotFoundException extends RuntimeException {

    public UrlShortenerNotFoundException(String message) {
        super(message);
    }
}
