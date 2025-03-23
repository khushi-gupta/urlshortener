package com.project.urlshortener.service;

import com.project.urlshortener.repository.UrlShortenerRepository;
import com.project.urlshortener.repository.Urls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

import static com.project.urlshortener.utils.CommonUtils.referenceTable;

@Service
public class UrlShortenerService {
    @Autowired
    UrlShortenerRepository urlShortenerRepository;

    public String createShortUrl(String longUrl) {
        // Generate UUID
        // Use UUID to generate base62 encoded suffix for the shortUrl, Store the uui, shorturl and longurl
        String uuid = generateUUID();
        String shortUrl = "http://localhost:8080/shorty/" + uuid;
        Urls url = new Urls();
        url.setUuid(uuid);
        url.setShortUrl(shortUrl);
        url.setLongUrl(longUrl);
        urlShortenerRepository.save(url);
        return shortUrl;
    }

    public String getLongUrl(String hashValue) {
        return urlShortenerRepository.findById(hashValue).get().getLongUrl();
    }

    private String generateUUID() {
        final String uuid = UUID.randomUUID().toString().replace("-", "");
        int numericID = 1;
        for (int i = 0; i < uuid.length(); i++) {
            int val = (int) uuid.charAt(i);
            if (val >= 48 && val <= 57) {
                numericID += (val - 48);
            } else if (val >= 65 && val <= 90) {
                numericID += (val - 65 + 11);
            } else if (val >= 97 && val <= 122) {
                numericID += (val - 97 + 73);
            }
        }

        int salt = (int) (Math.ceil(Math.random() * 150) * 23 * 3);
        numericID = numericID + salt;
        String finalUuid = "";
        while (numericID > 0) {
            int remainder = numericID % 62;
            numericID = numericID / 62;
            finalUuid = finalUuid.concat(String.valueOf(referenceTable.get(remainder)));
        }
        return finalUuid;
    }
}
