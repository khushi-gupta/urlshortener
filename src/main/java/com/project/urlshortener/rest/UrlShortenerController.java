package com.project.urlshortener.rest;

import com.project.urlshortener.service.UrlShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class UrlShortenerController {
    @Autowired
    UrlShortenerService urlShortenerService;

    @PostMapping("/shortUrl")
    public String createShortUrl(@RequestBody  String longUrl) {
        return urlShortenerService.createShortUrl(longUrl);
    }

    @GetMapping("/shorty/{hashValue}")
    public String getLongUrl(@PathVariable  String hashValue) {
        return urlShortenerService.getLongUrl(hashValue);
    }
}
