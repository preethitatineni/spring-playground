package com.example;

import com.example.model.Lesson;
import com.example.repositories.LessonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import javax.transaction.Transactional;

import java.sql.Date;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by trainer6 on 5/7/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LessonsRepositoryTest {
    @Autowired
    MockMvc mvc;

    @Autowired
    LessonRepository repository;

    @Test
    @Transactional
    @Rollback
    public void testCreate() throws Exception {
        MockHttpServletRequestBuilder request = post("/lessons")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\": \"lessonOne\"}");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", instanceOf(Number.class) ));
    }

    @Test
    @Transactional
    @Rollback
    public void testLessonById() throws Exception {
        Lesson lesson = new Lesson();
        lesson.setTitle("TestLesson");
        Lesson savedLesson = repository.save(lesson);

        MockHttpServletRequestBuilder request = get("/lessons/"+savedLesson.getId())
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", equalTo(lesson.getId().intValue()) ));
    }

    @Test
    @Transactional
    @Rollback
    public void testPatchLessonById() throws Exception{
        Lesson initialLesson = new Lesson();
        initialLesson.setTitle("Initial Lesson");
        initialLesson.setDeliveredOn(Date.valueOf("2017-05-04"));
        Lesson savedLesson = repository.save(initialLesson);

        MockHttpServletRequestBuilder request = patch("/lessons/"+savedLesson.getId())
                .contentType(MediaType.APPLICATION_JSON).content("{\n" +
                        "  \"title\": \"Updated Lesson\",\n" +
                        "  \"deliveredOn\": \"2017-04-12\"\n" +
                        "}");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", equalTo("Updated Lesson")));
    }

    @Test
    @Transactional
    @Rollback
    public void testFindByTitle() throws Exception{
        Lesson lesson = new Lesson();
        lesson.setTitle("LessonTitle");
        lesson.setDeliveredOn(Date.valueOf("2017-05-05"));
        repository.save(lesson);

        MockHttpServletRequestBuilder request = get("/lessons/find/LessonTitle");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", equalTo("LessonTitle")));
    }

    @Test
    @Transactional
    @Rollback
    public void testFindBetweenDates() throws Exception{
        Lesson lesson = new Lesson();
        lesson.setTitle("BetweenDate");
        lesson.setDeliveredOn(Date.valueOf("2013-04-20"));
        repository.save(lesson);

        MockHttpServletRequestBuilder request = get("/lessons/between?date1=2013-04-15&date2=2013-05-05");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", equalTo("BetweenDate")))
                .andExpect(jsonPath("$.deliveredOn", equalTo("2013-04-20")));
    }
}
