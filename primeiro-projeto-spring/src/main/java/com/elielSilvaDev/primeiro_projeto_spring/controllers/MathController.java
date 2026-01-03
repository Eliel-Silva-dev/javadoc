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
            @PathVariable String numberTwo)throws IllegalArgumentException {

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new IllegalArgumentException();

        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null || strNumber.isEmpty()) return false;
        String number = strNumber.replace(",", ".");

        return number.matches("[-+]?[0-9]*.?[0-9]+");
    }

    private Double convertToDouble(String strNumber) {

        if (strNumber == null || strNumber.isEmpty()) throw new IllegalArgumentException();
        String number = strNumber.replace(",", ".");

        return Double.parseDouble(number);
    }

    // http://localhost:8080/math/



    // http://localhost:8080/math/
}
