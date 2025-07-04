package models.Product;

public class ShippableNotExpirable extends Product implements Shippable {


    public ShippableNotExpirable(String name, double price, int quantity, double weight) {
        super(name, price, quantity, weight);

    }

    @Override
    public boolean isExpired() {
        return false;
    }

    @Override
    public boolean requiresShipping() {
        return true;
    }



}
