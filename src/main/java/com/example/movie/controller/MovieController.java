package com.example.movie.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieController {

    private final String omdbUrl;
    private final String omdbKey;


    public MovieController(@Value("${omdb.url}") String omdbUrl,
                           @Value("${omdb.apikey}") String omdbKey) {
        this.omdbUrl = omdbUrl;
        this.omdbKey = omdbKey;
    }

    @GetMapping(path = "movies/{id}/ombd")
    public String getExpandedInfo(@PathVariable String id) {
        return getJsonFromOmbd(id);
    }

    private String getJsonFromOmbd(String id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(omdbUrl + "?i=" + id + "&apikey=" + omdbKey, String.class);
    }
}