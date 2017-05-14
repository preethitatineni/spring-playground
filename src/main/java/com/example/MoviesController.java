package com.example;

import com.example.model.Movie;
import com.example.model.OmdbMovie;
import com.example.model.OmdbResponse;
import com.example.model.Search;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by trainer6 on 5/13/17.
 */
@RestController
public class MoviesController {

    RestTemplate template = new RestTemplate();

    @GetMapping("/movies")
    public List<Search> getMovies(@RequestParam("q") String query){
        ResponseEntity<OmdbResponse> response =  this.template.getForEntity("http://www.omdbapi.com/?s={query}", OmdbResponse.class, query);
        OmdbResponse omdbResponse = response.getBody();
        return omdbResponse.getSearch();
    }

    public RestTemplate getTemplate(){
        return template;
    }

}
