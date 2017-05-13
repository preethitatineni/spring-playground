package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by trainer6 on 5/13/17.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(MoviesController.class)
public class MoviesControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testGetMovies() throws Exception{

        MockHttpServletRequestBuilder request = get("/movies?q=harry").contentType(MediaType.APPLICATION_JSON_UTF8);
        this.mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].title").exists())
                .andExpect(jsonPath("$.[0].imdbId").exists())
                .andExpect(jsonPath("$.[0].poster").exists())
                .andExpect(jsonPath("$.[0].year").exists())
                .andExpect(jsonPath("$.[0].type").doesNotExist());

    }
}
