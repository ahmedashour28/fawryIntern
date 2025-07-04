package models.Cart;

import models.Product.Product;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    public List<CartItem> items = new ArrayList<>();

    public void addToCart(Product product, int quantity) {
        if (quantity > product.quantity) {
            System.out.println("Not enough stock for " + product.name);
            return;
        }
        items.add(new CartItem(product, quantity));
        product.quantity -= quantity;
    }

    public double calculateSubTotal() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getTotalPrice();
        }
        return total;
    }

    public double calculateShipping() {
        double shipping ;
        double totalWeight=0;
        for (CartItem item : items) {
            if(item.product.requiresShipping()) {
                totalWeight += item.product.weight*item.quantity;
            }
        }
        shipping = totalWeight/1000*30;
        return shipping;
    }

    public double calculateTotal() {
        return calculateShipping()+calculateSubTotal();
    }

    }
