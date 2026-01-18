package service;

public class Purchase implements Comparable<Purchase> {
    private String descricao;
    private double valor;

    public Purchase(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Compra: descrição = " + descricao + "valor = " + valor;
    }

    @Override
    public int compareTo(Purchase oderPurchase) {
        return Double.valueOf(this.valor).compareTo(Double.valueOf(oderPurchase.valor));
    }
}
