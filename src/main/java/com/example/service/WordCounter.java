package com.example.service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by trainer6 on 5/7/17.
 */
public class WordCounter {
    public Map<String, Integer> countWords(String sentence){
        String[] words = sentence.replaceAll("[^a-zA-Z ]", "").split(" ");
        Map<String, Integer> map = new HashMap<>();
        for(String word : words){
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
