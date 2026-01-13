package br.com.alura;

import java.util.Scanner;

public class CalculateArea {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int option = 0;

        while (option != 3) {
            System.out.println("-----Menu-----");
            System.out.println("1. Calculate the area of a square");
            System.out.println("2. Calculate the area of a circle");
            System.out.println("3. Close");
            System.out.print("Choose an option: ");
            option = scan.nextInt();

            if(option == 1) {
                System.out.println("Enter the side of the square:");
                double side = scan.nextInt();
                double squareArea = side * side;
                System.out.println("Square area: " + squareArea);
                System.out.println(" ");
            } else if(option == 2) {
                System.out.print("Enter the radius of the circle: ");
                double radios = scan.nextDouble();
                double areaCircle = 3.14 * radios * radios;
                System.out.println("Circle area: " + areaCircle);
            } else if (option == 3 ){
                System.out.println("Program closed");
            } else {
                System.out.println("Invalid option");
            }
        }

    }
}