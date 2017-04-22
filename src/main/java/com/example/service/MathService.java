package com.example.service;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by trainer6 on 4/22/17.
 */
@Component
public interface MathService {
    public String mathCalculate (String operation, int x, int y);
    public String mathSum(List<String> values);
}
