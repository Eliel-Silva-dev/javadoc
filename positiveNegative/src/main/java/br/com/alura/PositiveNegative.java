package br.com.alura;


import java.util.Scanner;

public class PositiveNegative {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int numero = scan.nextInt();

        if (numero > 0) {
            System.out.println("Positive number! ");
        } else {
            System.out.println("Negative Number! ");
        }
    }
}