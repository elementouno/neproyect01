package ca.ciccc.assignment5.question2;

import java.util.ArrayList;

public class Product {
    private String name;
    private double price;

    Product(String name, Float price) {
        this.name = name;
        this.price = price;
    }

    public void getProduct(Product p) {
        System.out.println(p.name);
        System.out.println(p.price);
    }

    public void getProduct() {
        System.out.println(name);
        System.out.println(price);
    }
}
