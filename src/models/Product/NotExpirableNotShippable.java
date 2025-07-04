package models.Product;

public class NotExpirableNotShippable extends Product {
    public NotExpirableNotShippable(String name, double price, int quantity) {
        super(name, price, quantity,0);
    }

    @Override
    public boolean isExpired() {
        return false;
    }

    @Override
    public boolean requiresShipping() {
        return false;
    }
}
