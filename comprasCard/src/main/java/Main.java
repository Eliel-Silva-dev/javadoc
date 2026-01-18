import entity.CreditCard;
import service.Purchase;

import javax.swing.*;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o limite do cartão: ");
        double limit = scan.nextDouble();
        CreditCard card = new CreditCard(limit);

        int out = 1;
        while(out != 0) {
            System.out.println("Digite a descrição da compra:");
            String descricao = scan.next();

            System.out.println("Digite o valor da compra:");
            double valor = scan.nextDouble();

            Purchase purchase = new Purchase(descricao, valor);
            boolean compraRealizada = card.enterPurchase(purchase);

            if (compraRealizada) {
                System.out.println("Compra realizada!");
                System.out.println("Digite 0 para sair ou 1 para continuar");
                out = scan.nextInt();
            } else {
                System.out.println("Saldo insuficiente!");
                out = 0;
            }
        }

        System.out.println("***********************");
        System.out.println("COMPRAS REALIZADAS:\n");

        Collections.sort(card.getPurchases());
        for (Purchase p : card.getPurchases()) {
            System.out.println(p.getDescribe() + " - " +p.getPrice());
        }
        System.out.println("\n***********************");

        System.out.println("\nSaldo do cartão: " + card.getBalance());
    }
}
