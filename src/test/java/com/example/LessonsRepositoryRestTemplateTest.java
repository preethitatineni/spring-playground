package com.example;

import com.example.model.Lesson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;

/**
 * Created by trainer6 on 5/25/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LessonsRepositoryRestTemplateTest {

    @Autowired
    TestRestTemplate template;

    @Test
    @Transactional
    @Rollback
    public void testCreateLesson(){
        Lesson lesson = new Lesson();
        lesson.setTitle("Lesson One");

        HttpEntity<Lesson> requestEntity = new HttpEntity<Lesson>(lesson);
        ResponseEntity<Lesson> responseEntity = template.exchange("/lessons", HttpMethod.POST, requestEntity, Lesson.class);
        assertThat(responseEntity.getStatusCode(), equalTo(HttpStatus.OK));
        Lesson savedLesson = responseEntity.getBody();
        assertThat(savedLesson.getId(), instanceOf(Long.class));
        assertThat(savedLesson.getTitle(), equalTo("Lesson One"));
    }
}
