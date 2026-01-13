package br.com.alura;

import br.com.alura.services.Comparison;

import java.util.Scanner;

public class ComparisonNumbers {

    public static void main(String[] args) {
        Scanner scan =  new Scanner(System.in);

        System.out.println("Enter the first number: ");
        double number1 = scan.nextDouble();

        System.out.println("Enter the second number: ");
        double number2 = scan.nextDouble();

        Comparison comparison = new Comparison();

        System.out.println(" ");
        if(number1 != number2) {
            System.out.println(comparison.isEquals(number1,number2));
            System.out.println(comparison.isBigger(number1,number2));
        } else {
            System.out.println(comparison.isEquals(number1,number2));
        }
    }
}
