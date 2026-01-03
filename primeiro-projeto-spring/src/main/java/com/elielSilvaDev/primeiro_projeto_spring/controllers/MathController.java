package com.elielSilvaDev.primeiro_projeto_spring.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    // http://localhost:8080/math/sum/3/5 - adds two numbers
    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
            @PathVariable String numberOne,
            @PathVariable String numberTwo) {

        return 1D;
    }

    // http://localhost:8080/math/



    // http://localhost:8080/math/
}
