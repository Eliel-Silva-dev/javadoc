/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.testetipos;

/**
 *
 * @author Eliel
 */
public class TesteTipos {

    public static void main(String[] args) {
        /*
        int idade = (int) 30;
        String valor = Integer.toString(idade);
        System.out.println(valor);
        */
        
        String valor = "30.5";
        float idade = Float.parseFloat(valor);
        System.out.println("A idade é: " + idade);
    }
}
