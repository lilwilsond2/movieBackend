package com.example.movie.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@RepositoryRestController
public class MovieController {

    private final String omdbUrl;
    private final String omdbKey;


    public MovieController(@Value("${omdb.url}") String omdbUrl,
                           @Value("${omdb.apikey}") String omdbKey) {
        this.omdbUrl = omdbUrl;
        this.omdbKey = omdbKey;
    }

    @GetMapping(path = "movies/{id}/omdb")
    public @ResponseBody ResponseEntity getExpandedInfo(@PathVariable String id) {
        return ResponseEntity.ok(getJsonFromOmdb(id));
    }

    private Object getJsonFromOmdb(String id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(omdbUrl + "?i=" + id + "&apikey=" + omdbKey, Object.class);
    }
}
