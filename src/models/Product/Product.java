package models.Product;

public abstract class Product {
    public String name;
    public double price;
    public int quantity;
    public double weight;


    public Product(String name, double price, int quantity,double weight) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.weight=weight;

    }

    public abstract boolean isExpired();
    public abstract boolean requiresShipping();


}
