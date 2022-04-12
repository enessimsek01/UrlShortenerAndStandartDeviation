package com.enessimsek.urlshortener.urlshortener.controller;


import com.enessimsek.urlshortener.urlshortener.dto.UrlShortenerDto;
import com.enessimsek.urlshortener.urlshortener.dto.UrlShortenerSaveRequestDto;
import com.enessimsek.urlshortener.urlshortener.service.UrlShortenerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;

@RestController
@RequestMapping("/api/v1/urlshorteners")
public class UrlShortenerController {


    private final UrlShortenerService urlShortenerService;

    public UrlShortenerController(UrlShortenerService urlShortenerService) {
        this.urlShortenerService = urlShortenerService;
    }

    @GetMapping("/{shortener}")
    public ResponseEntity<UrlShortenerDto> findUrlByShortener(@PathVariable String shortener) throws Exception {
        UrlShortenerDto urlByShortener = urlShortenerService.getUrlByShortener(shortener);
        URI uri=new URI(urlByShortener.getUrl());
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.setLocation(uri);
        return new ResponseEntity<UrlShortenerDto>(httpHeaders, HttpStatus.MOVED_PERMANENTLY);
    }

    @PostMapping("/")
    public ResponseEntity<UrlShortenerSaveRequestDto> saveUrlShortener(@RequestBody UrlShortenerSaveRequestDto urlShortenerSaveRequestDto){
        urlShortenerService.saveUrlShortener(urlShortenerSaveRequestDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
