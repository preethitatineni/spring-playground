package com.example.service;

import com.example.config.WordCountConfig;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by trainer6 on 5/7/17.
 */
public class WordCounter {

    @Autowired
    WordCountConfig config;

    public Map<String, Integer> countWords(String sentence){
        if(!config.isCaseSensitive()){
            sentence = sentence.toLowerCase();
        }
        String[] words = sentence.replaceAll("[^a-zA-Z ]", "").split(" ");
        Map<String, Integer> map = new HashMap<>();
        for(String word : words){
            if(config.getSkip().contains(word)){
                continue;
            }
            if(map.get(word) == null){
                map.put(word, 1);
            }else{
                Integer initialCount = map.get(word);
                map.put(word, initialCount + 1);
            }
        }
        return map;
    }
}
