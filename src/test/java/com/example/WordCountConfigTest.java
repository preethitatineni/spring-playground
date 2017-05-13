package com.example;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by trainer6 on 5/13/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(properties = {
        "wordCount.caseSensitive=true",
        "wordCount.words.skip[0]=the",
        "wordCount.words.skip[1]=an",
        "wordCount.words.skip[2]=a"
})
public class WordCountConfigTest {
}
