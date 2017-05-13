package com.example.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by trainer6 on 5/13/17.
 */
@Component
@ConfigurationProperties("wordCount")
public class WordCountConfig {
    private boolean caseSensitive = false;
   // private Words words;

    public boolean isCaseSensitive() {
        return caseSensitive;
    }

    public void setCaseSensitive(boolean caseSensitive) {
        this.caseSensitive = caseSensitive;
    }

    private List<String> skip = new ArrayList<>();

    public List<String> getSkip() {
        return skip;
    }

//    public void setSkip(List<String> skip) {
//        this.skip = skip;
//    }
//
//    public Words getWords() {
//        return words;
//    }
//
//    public void setWords(Words words) {
//        this.words = words;
//    }
//
//    public class Words {
//     private List<String> skip = new ArrayList<>();
//
//        public List<String> getSkip() {
//            return skip;
//        }
//
//        public void setSkip(List<String> skip) {
//            this.skip = skip;
//        }
//    }
}
