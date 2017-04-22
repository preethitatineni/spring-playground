package com.example;


import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by trainer6 on 4/22/17.
 */
@RestController
public class MathController {

    @GetMapping("/math/calculate")
    public String mathCalculate(@RequestParam(defaultValue = "add") String operation, @RequestParam int x, @RequestParam int y){
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

    @PostMapping("/math/sum")
    public String mathSum(@RequestParam MultiValueMap<String, String> n){
        StringBuilder builder = new StringBuilder();
        Iterator iterator = n.values().iterator();
        List<String> valueList = null;
        int totalValue = 0;
        int currentVal = 0;
        valueList = (List) iterator.next();
        for(String str : valueList) {
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
