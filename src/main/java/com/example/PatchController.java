package com.example;

import com.example.model.Movie;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by trainer6 on 4/23/17.
 */
@RestController
public class PatchController {

    @PatchMapping(value = "/movies/{id}/update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Movie moviePatch(@PathVariable int id){
        Movie movie = new Movie();
        movie.setId(id);
        movie.setTitle("Title");
        return movie;
    }
}
