package com.enessimsek.urlshortener.urlshortener.converter;

import com.enessimsek.urlshortener.urlshortener.dto.UrlShortenerDto;
import com.enessimsek.urlshortener.urlshortener.dto.UrlShortenerSaveRequestDto;
import com.enessimsek.urlshortener.urlshortener.entity.UrlShortener;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UrlShortenerConverter {

    UrlShortenerConverter INSTANCE= Mappers.getMapper(UrlShortenerConverter.class);

    UrlShortenerDto convertUrlShortenerToUrlShortenerDto(UrlShortener urlShortener);

    UrlShortener convertUrlShortenerSaveRequestDtoToUrlShortener(UrlShortenerSaveRequestDto urlShortenerSaveRequestDto);
}
