package com.example.repositories;

import com.example.model.Lesson;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

/**
 * Created by trainer6 on 5/7/17.
 */
public interface LessonRepository extends CrudRepository<Lesson, Long> {

    public Lesson findByTitle(String title);

    public Lesson findByDeliveredOnAfterAndDeliveredOnBefore(Date afterDate, Date beforeDate);

}
