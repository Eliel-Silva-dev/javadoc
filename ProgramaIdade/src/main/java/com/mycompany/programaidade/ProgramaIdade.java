/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.programaidade;

import java.util.Scanner;
/**
 *
 * @author Eliel
 */
public class ProgramaIdade {

    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        
        System.out.println("Em que ano você nasceu? ");
        int nasc = t.nextInt();
        int i = 2025 - nasc;
        
        System.out.println("Sua idade é: " + i);
        
        if (i >= 18) {
            System.out.println("Maior de idade");
        } else {
            System.out.println("Menor de idade");
        }
    }
}
