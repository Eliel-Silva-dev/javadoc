/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.resolucaosistema;

import java.awt.Toolkit;
import java.awt.Dimension;

/**
 *
 * @author Eliel
 */
public class ResolucaoSistema {

    public static void main(String[] args) {
        // obtem uma referencia toolkit padão do sistema
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        
        // usa o método screenSize para obter a resolução da rela principal
        Dimension screenSize = toolkit.getScreenSize();
        
        // a classe dimension armazena a larguara e a autura
        int altura = (int) screenSize.getHeight();
        int largura = (int) screenSize.getWidth();
           
        System.out.println("Sua tela tem resolução de " + largura + " x " + altura);
    }
}
