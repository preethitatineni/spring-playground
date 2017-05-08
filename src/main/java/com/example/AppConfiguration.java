package com.example;

import com.example.service.WordCounter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by trainer6 on 5/7/17.
 */
@Configuration
public class AppConfiguration {
    @Bean
    WordCounter counter(){
        return new WordCounter();
    }
}
