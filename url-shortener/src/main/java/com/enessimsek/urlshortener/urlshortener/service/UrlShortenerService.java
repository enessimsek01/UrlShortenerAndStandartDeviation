package com.enessimsek.urlshortener.urlshortener.service;

import com.enessimsek.urlshortener.urlshortener.converter.UrlShortenerConverter;
import com.enessimsek.urlshortener.urlshortener.dao.UrlShortenerDao;
import com.enessimsek.urlshortener.urlshortener.dto.UrlShortenerDto;
import com.enessimsek.urlshortener.urlshortener.dto.UrlShortenerSaveRequestDto;
import com.enessimsek.urlshortener.urlshortener.entity.UrlShortener;
import com.enessimsek.urlshortener.urlshortener.exception.CustomizedResponseEntityExceptionHandler;
import com.enessimsek.urlshortener.urlshortener.exception.UrlShortenerNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UrlShortenerService {

    private final UrlShortenerDao urlShortenerDao;

    public UrlShortenerService(UrlShortenerDao urlShortenerDao) {
        this.urlShortenerDao = urlShortenerDao;
    }

    public UrlShortenerDto getUrlByShortener(String shortener) {

        UrlShortener urlShortener = urlShortenerDao.findByShortener(shortener)
                .orElseThrow(()->new UrlShortenerNotFoundException("Url Shortener Not Found"));

        UrlShortenerDto urlShortenerDto=UrlShortenerConverter
                .INSTANCE
                .convertUrlShortenerToUrlShortenerDto(urlShortener);
        return urlShortenerDto;

    }

    public UrlShortenerDto saveUrlShortener(UrlShortenerSaveRequestDto urlShortenerSaveRequestDto){

        UrlShortener urlShortener=UrlShortenerConverter
                .INSTANCE
                .convertUrlShortenerSaveRequestDtoToUrlShortener(urlShortenerSaveRequestDto);

        urlShortener=urlShortenerDao.save(urlShortener);
        UrlShortenerDto urlShortenerDto=UrlShortenerConverter
                .INSTANCE
                .convertUrlShortenerToUrlShortenerDto(urlShortener);

        return urlShortenerDto;

    }


}
