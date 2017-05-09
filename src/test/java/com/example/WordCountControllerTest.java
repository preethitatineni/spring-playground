package com.example;

import com.example.service.WordCounter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by trainer6 on 5/8/17.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class WordCountControllerTest {
    @Autowired
    MockMvc mvc;
    @Autowired
    WordCounter counter;

    @Test
    public void testCounter() throws Exception {
        MockHttpServletRequestBuilder request = post("/words/count").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("January February March March");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.January").value(1))
                .andExpect(jsonPath("$.February").value(1))
                .andExpect(jsonPath("$.March").value(2));
    }
}
