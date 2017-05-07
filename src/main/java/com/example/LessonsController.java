package com.example;

import com.example.model.Lesson;
import com.example.repositories.LessonRepository;
import org.springframework.web.bind.annotation.*;

import static org.apache.coyote.http11.Constants.a;

/**
 * Created by trainer6 on 5/7/17.
 */
@RestController
@RequestMapping("/lessons")
public class LessonsController {

    private final LessonRepository repository;

    public LessonsController(LessonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public Iterable<Lesson> all() {
        return this.repository.findAll();
    }

    @PostMapping("")
    public Lesson create(@RequestBody Lesson lesson) {
        return this.repository.save(lesson);
    }

    @GetMapping("/{id}")
    public Lesson getLessonById(@PathVariable Long id){
        return repository.findOne(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        repository.delete(id);
    }

    @PatchMapping("/{id}")
    public Lesson update(@PathVariable Long id, @RequestBody Lesson lesson){
        lesson.setId(id);
        return repository.save(lesson);
    }

}