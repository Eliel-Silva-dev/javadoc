/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.outputinpu;

import java.util.Scanner;

/**
 *
 * @author Eliel
 */
public class OutputInpu {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Digite seu nome: ");
        String nome = teclado.nextLine();
        System.out.print("Digite sua nota: ");
        float nota = teclado.nextFloat();
                
        System.out.format("A nota de %s e %.0f \n", nome, nota);
    }
}
