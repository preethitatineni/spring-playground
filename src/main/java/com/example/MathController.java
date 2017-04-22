package com.example;


import com.example.service.MathService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    MathService mathService;

    @GetMapping("/math/calculate")
    public String mathCalculate(@RequestParam(defaultValue = "add") String operation, @RequestParam int x, @RequestParam int y){
        return mathService.mathCalculate(operation, x, y);
    }

    @PostMapping("/math/sum")
    public String mathSum(@RequestParam MultiValueMap<String, String> n){
        Iterator iterator = n.values().iterator();
        List<String> valueList = null;
        valueList = (List) iterator.next();
        return mathService.mathSum(valueList);
    }



}
