package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

}
