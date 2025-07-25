package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private double price;

    public SimpleProduct(String name, double price) {
        super(name);
        if (price < 1) {
            throw new IllegalArgumentException("Цена не может быть меньше 0");
        }
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return getName() + ": " + price;
    }

    @Override
    public boolean IsSpecial() {
        return false;
    }
}
