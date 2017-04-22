package com.example.service;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by trainer6 on 4/22/17.
 */
@Component
public class MathServiceImpl implements MathService {

    @Override
    public String mathCalculate(String operation, int x, int y) {
        String operationSymbol = null;
        int totalValue = 0;
        switch (operation) {
            case "add":
                operationSymbol = "+";
                totalValue = x + y;
                break;
            case "subtract":
                operationSymbol = "-";
                totalValue = x - y;
                break;
            case "multiply":
                operationSymbol = "*";
                totalValue = x * y;
                break;
            case "divide":
                operationSymbol= "/";
                totalValue = x / y;
        }
        return String.format("%s %s %s = %s", x, operationSymbol, y, totalValue);
    }

    @Override
    public String mathSum(List<String> values) {
        StringBuilder builder = new StringBuilder();
        int totalValue = 0;
        int currentVal = 0;

        for(String str : values) {
            if(!builder.toString().isEmpty()){
                builder.append(" + ");
            }
            currentVal = Integer.valueOf(str);
            builder.append(currentVal);
            totalValue += currentVal;
        }

        builder.append(" = " + totalValue);
        return builder.toString();
    }
}
