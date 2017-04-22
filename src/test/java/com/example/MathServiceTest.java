package com.example;

import com.example.service.MathService;
import com.example.service.MathServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by trainer6 on 4/22/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MathServiceTest {

    @Autowired
    MathService service;

    @Test
    public void testMathSum(){
        assertEquals("5 + 5 = 10", service.mathCalculate("add", 5   , 5));
    }

    @Test
    public void testMathDefaultSum(){
        assertEquals("5 + 5 = 10", service.mathCalculate("add", 5   , 5));
    }

    @Test
    public void testMathSubtract(){
        assertEquals("5 - 5 = 0", service.mathCalculate("subtract", 5   , 5));
    }

    @Test
    public void testMathMultiply(){
        assertEquals("5 * 5 = 25", service.mathCalculate("multiply", 5   , 5));
    }

    @Test
    public void testMathDivide(){
        assertEquals("5 / 5 = 1", service.mathCalculate("divide", 5   , 5));
    }

    @Test
    public void testMathMultipleSum(){
        List<String> values = new ArrayList<String>();
        values.add("5");
        values.add("7");
        values.add("23");
        assertEquals("5 + 7 + 23 = 35", service.mathSum(values));
    }






}
