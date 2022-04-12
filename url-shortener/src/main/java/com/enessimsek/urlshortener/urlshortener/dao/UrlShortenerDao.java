package com.enessimsek.urlshortener.urlshortener.dao;


import com.enessimsek.urlshortener.urlshortener.entity.UrlShortener;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlShortenerDao extends JpaRepository<UrlShortener,Long> {

    Optional<UrlShortener> findByShortener(String shortener);



}
