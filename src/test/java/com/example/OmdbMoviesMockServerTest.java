package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;


import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by trainer6 on 5/14/17.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = MoviesController.class)
public class OmdbMoviesMockServerTest {

    @Autowired
    MoviesController controller;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testMockOmdbServer() throws Exception{
        RestTemplate template = controller.getTemplate();
        MockRestServiceServer mockRestServiceServer = MockRestServiceServer.createServer(template);

        mockRestServiceServer.expect(requestTo("http://www.omdbapi.com/?s=harry"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess(getJSON("/omdbjson.json"), MediaType.APPLICATION_JSON));

        MockHttpServletRequestBuilder request = get("/movies?q=harry").contentType(MediaType.APPLICATION_JSON_UTF8);
        this.mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].title").exists())
                .andExpect(jsonPath("$.[0].imdbId").exists())
                .andExpect(jsonPath("$.[0].poster").exists())
                .andExpect(jsonPath("$.[0].year").exists())
                .andExpect(jsonPath("$.[0].type").doesNotExist());

        mockRestServiceServer.verify();
    }

    private String getJSON(String path) throws Exception {
        URL url = this.getClass().getResource(path);
        return new String(Files.readAllBytes(Paths.get(url.getFile())));
    }

}
