package entity;

import service.Purchase;

import java.util.ArrayList;
import java.util.List;

public class CreditCard {
    private final double limit;
    private double balance;
    private List<Purchase> purchases;

    public CreditCard(double limit) {
        this.limit = limit;
        this.balance = limit;
        this.purchases = new ArrayList<>();
    }

    public boolean enterPurchase(Purchase purchase) {
        if(this.limit > purchase.getPrice()) {
            this.balance -= purchase.getPrice();
            this.purchases.add(purchase);
            return true;
        }
        return false;
    }
    public double getLimit() {
        return limit;
    }

    public double getBalance() {
        return balance;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }
}
