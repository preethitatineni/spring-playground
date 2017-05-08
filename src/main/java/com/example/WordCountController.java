package com.example;

import com.example.service.WordCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by trainer6 on 5/7/17.
 */
@RestController
public class WordCountController {

    @Autowired
    WordCounter wordCounter;

    @PostMapping("/words/count")
    public Map<String, Integer> wordCounter(@RequestBody String sentence){
        return wordCounter.countWords(sentence);
    }
}
