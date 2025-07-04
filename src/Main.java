import models.Cart.Cart;
import models.Cart.CartItem;
import models.Customer;
import java.time.LocalDate;
import models.Product.ExpirableAndShippable;
import models.Product.NotExpirableNotShippable;
import models.Product.ShippableNotExpirable;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        /* ExpirableAndShippable it is a product type that can be expired and shipped
            it's take 5 parameters
            1- the name of the product  2- the price of the product   3- the stock quantity of the product
            4- the weight of one portion of the product in grams   5- the expire date
        */
        ExpirableAndShippable cheese = new ExpirableAndShippable("cheese", 200, 50, 200, LocalDate.of(2025, 12, 10));
        ExpirableAndShippable biscuits = new ExpirableAndShippable("Biscuits", 50, 100, 100, LocalDate.of(2026, 12, 10));

        /* ShippableNotExpirable it is a product type that can be shipped
            it's take 4 parameters
            1- the name of the product  2- the price of the product   3- the stock quantity of the product
            4- the weight of one portion of the product in grams
        */
        ShippableNotExpirable TV = new ShippableNotExpirable("TV", 1500, 70, 7000);

        /* NotExpirableNotShippable it is a product type that cannot be shipped or be expired
            it's take 3 parameters
            1- the name of the product  2- the price of the product   3- the stock quantity of the product
        */
        NotExpirableNotShippable mobileScratchCards = new NotExpirableNotShippable("mobileScratchCards", 10, 200);

        Customer customer = new Customer(4000); // customer class that recieves the balance
        Cart cart = new Cart();
        cart.addToCart(cheese, 2);
        cart.addToCart(biscuits, 1);
        cart.addToCart(TV, 1);
        cart.addToCart(mobileScratchCards, 1);
        checkout(customer,cart);


    }

    public static void checkout(Customer customer, Cart cart) {
        if (cart.items.isEmpty()){
            throw new IllegalArgumentException("the cart is empty");
        }
        if (cart.calculateTotal() > customer.balance) {
            throw new IllegalArgumentException("balance is insufficient");
        }
        System.out.println("** Shipment notice **");
        double totalWeight=0;
        for (CartItem item : cart.items) {
            double itemWeight = 0;
            if (item.product.requiresShipping()) {
                itemWeight = item.product.weight * item.quantity;
                totalWeight += item.product.weight*item.quantity;
                System.out.println(item.quantity + "x  " + item.product.name + "     " + itemWeight + "g");
            }

        }
        System.out.println("Total package weight is "+totalWeight/1000+" Kg");
        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.items) {
                System.out.println(item.quantity + "x  " + item.product.name + "     " + item.product.price*item.quantity);

        }
        System.out.println("---------------------------------");
        System.out.println("Subtotal       "+cart.calculateSubTotal());
        System.out.println("Shipping       "+cart.calculateShipping());
        System.out.println("Amount       "+cart.calculateTotal());
        double currentBalance = customer.balance - cart.calculateTotal();
        System.out.println("customer current balance   "+currentBalance);

    }
}