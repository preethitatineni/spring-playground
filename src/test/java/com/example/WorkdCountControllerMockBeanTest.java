package com.example;

import com.example.service.WordCounter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by trainer6 on 5/8/17.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(WordCountController.class)
public class WorkdCountControllerMockBeanTest {

    @MockBean
    WordCounter counter;

    @Autowired
    MockMvc mvc;

    @Before
    public void setUp(){
        Map<String, Integer> map = new HashMap<>();
        map.put("Jan", 1);
        map.put("Feb", 1);
        map.put("Mar", 2);
        when(counter.countWords("Jan Feb Mar Mar")).thenReturn(map);
    }

    @Test
    public void testWordController() throws Exception{
        MockHttpServletRequestBuilder request = post("/words/count").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("Jan Feb Mar Mar");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.Jan").value(1))
                .andExpect(jsonPath("$.Feb").value(1))
                .andExpect(jsonPath("$.Mar").value(2));
    }
}
