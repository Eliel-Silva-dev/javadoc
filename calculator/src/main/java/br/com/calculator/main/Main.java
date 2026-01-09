package br.com.calculator.main;

import br.com.calculator.bean.Calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {
            Scanner scan = new Scanner(System.in);
            Calculator calcualtor = new Calculator();
            double result = 0;

            System.out.println("Enter the first number");
            double val1 = scan.nextDouble();
            System.out.println(" ");

            System.out.println("Enter the second number");
            double val2 = scan.nextDouble();
            System.out.println(" ");

            System.out.println("Choose the operation: \n 1-(+) \n 2-(-) \n 3-(*) \n 4-(/) \n > ");
            int operation = scan.nextInt();
            System.out.println(" ");

            switch (operation) {
                case 1:
                    result = calcualtor.sum(val1, val2);
                    break;
                case 2:
                    result = calcualtor.subtract(val1, val2);
                    break;
                case 3:
                    result = calcualtor.multiply(val1, val2);
                    break;
                case 4:
                    result = calcualtor.division(val1, val2);
                    break;
                default:
                    System.out.println("Invalid operation, try again");
                    break;
            }

            System.out.println("The result of the operation is: " + result);

        }catch (Exception e) {
            throw new RuntimeException("Error in calculation!!!");
        }
    }
}
