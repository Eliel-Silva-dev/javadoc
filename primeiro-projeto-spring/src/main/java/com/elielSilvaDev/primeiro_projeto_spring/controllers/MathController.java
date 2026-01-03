package com.elielSilvaDev.primeiro_projeto_spring.controllers;

import com.elielSilvaDev.primeiro_projeto_spring.exception.UnsupportedMathOperationException;
import com.elielSilvaDev.primeiro_projeto_spring.math.SimpleMath;
import com.elielSilvaDev.primeiro_projeto_spring.request.converters.NumberConverter;
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

        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value");

        return SimpleMath.sum(NumberConverter.convertToDouble(numberOne),NumberConverter.convertToDouble(numberTwo));
    }

    // http://localhost:8080/math/subtraction/
    @RequestMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(
            @PathVariable String numberOne,
            @PathVariable String numberTwo)throws IllegalArgumentException {

        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value");

        return SimpleMath.subtraction(NumberConverter.convertToDouble(numberOne),NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(
            @PathVariable String numberOne,
            @PathVariable String numberTwo)throws IllegalArgumentException {

        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value");

        return SimpleMath.multiplication(NumberConverter.convertToDouble(numberOne),NumberConverter.convertToDouble(numberTwo));
    }
    @RequestMapping("/division/{numberOne}/{numberTwo}")
    public Double division(
            @PathVariable String numberOne,
            @PathVariable String numberTwo)throws IllegalArgumentException {

        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value");

        return SimpleMath.division(NumberConverter.convertToDouble(numberOne),NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping("/squareroot/{numberOne}")
    public Double squareRoot(
            @PathVariable String numberOne)throws IllegalArgumentException {

        if(!NumberConverter.isNumeric(numberOne))
            throw new UnsupportedMathOperationException("Please set a numeric value");

        return SimpleMath.squareRoot(NumberConverter.convertToDouble(numberOne));
    }
}
