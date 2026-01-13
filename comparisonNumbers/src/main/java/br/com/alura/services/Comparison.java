package br.com.alura.services;

import java.util.Objects;

public class Comparison {

    public String isEquals (double val1,double val2) {
        if(val1 == val2) {
            return "The numbers are equal";
        } else {
            return "The numbers are not equal";
        }
    }

    public String isBigger (double val1,double val2) {
        if(val1 > val2) {
            return "The first number is greater than the second";
        } else {
            return "The second number is greater than the first";
        }
    }
}
