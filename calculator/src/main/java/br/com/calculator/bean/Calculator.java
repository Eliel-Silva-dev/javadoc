package br.com.calculator.bean;

public class Calculator {

    public double sum(double val1, double val2) {
        return val1 + val2;
    }
    public double subtract(double val1, double val2) {
        return val1 - val2;
    }
    public double multiply(double val1, double val2) {
        return val1 * val2;
    }
    public double division(double val1, double val2) {
        if (val2 == 0) {
            throw new RuntimeException("It is not possible to divide by zero!");
        }
        return val1 / val2;
    }
}
