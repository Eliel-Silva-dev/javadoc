package service;

public class Purchase implements Comparable<Purchase> {
    private String describe;
    private double price;

    public Purchase(String describe, double valor) {
        this.describe = describe;
        this.price = valor;
    }

    public String getDescribe() {
        return describe;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Compra: descrição = " + describe + "valor = " + price;
    }

    @Override
    public int compareTo(Purchase oderPurchase) {
        return Double.valueOf(this.price).compareTo(Double.valueOf(oderPurchase.price));
    }
}
