package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by trainer6 on 4/23/17.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(MathVolumeController.class)
public class MathVolumeControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    public void testVolume() throws Exception{
        mvc.perform(get("/math/volume/10/5/20")).andExpect(status().isOk()).andExpect(content().string("The volume of a 10x5x20 rectangle is 1000"));

    }
}
