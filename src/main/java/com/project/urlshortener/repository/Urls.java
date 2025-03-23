package com.project.urlshortener.repository;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Urls {
    @Id
    private String uuid;
    private String longUrl;
    private String shortUrl;

    public Urls() {
    }

    public String getUuid() {
        return uuid;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getShortUrl() {
        return shortUrl;
    }
}
