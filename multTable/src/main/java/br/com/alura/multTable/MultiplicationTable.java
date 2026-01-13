package br.com.alura.multTable;

import java.util.Scanner;

public class MultiplicationTable {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Multiplication table \n");
        System.out.println("Enter a number: ");
        int number = scan.nextInt();

        System.out.println("Multiplication table of " + number + ": ");

        for(int i = 0; i <= 10; i++) {
            System.out.println(number + "x" + i + " = " + (number * i));
        }
    }
}
