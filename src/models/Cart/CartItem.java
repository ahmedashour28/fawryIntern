package models.Cart;
import models.Product.Product;

public class CartItem {
    public Product product;
    public int quantity;

    public CartItem(Product product, int quantity) {
        if (quantity > product.quantity) {
            throw new IllegalArgumentException("Quantity exceeds available stock");
        }
        if (product.isExpired()){
            throw new IllegalArgumentException("product is expired !!!!!!");
        }
        this.product = product;
        this.quantity = quantity;
    }

    public double getTotalPrice() {

        return product.price * quantity;

    }
}
