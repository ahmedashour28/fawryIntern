package models.Product;

import java.time.LocalDate;

public  class ExpirableAndShippable extends Product implements Expirable, Shippable {
    private LocalDate expiryDate;


    public ExpirableAndShippable(String name, double price, int quantity, double weight, LocalDate expiryDate) {
        super(name, price, quantity,weight);
        this.expiryDate = expiryDate;

    }

    @Override
    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }

    @Override
    public boolean requiresShipping() {
        return true;
    }



}

