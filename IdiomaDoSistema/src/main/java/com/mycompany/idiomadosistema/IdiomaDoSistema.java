/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.idiomadosistema;

import java.util.Locale;

/**
 *
 * @author Eliel
 */
public class IdiomaDoSistema {

    public static void main(String[] args) {
        Locale idiomaSistema = Locale.getDefault();
        
        System.out.println("Seu sistema esta em: " + idiomaSistema.getDisplayLanguage());
        
    }
}
