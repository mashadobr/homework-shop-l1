package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private static final double PRICE = 100;

    public FixPriceProduct(String name) {
        super(name);
    }

    public double getPrice() {
        return PRICE;
    }

    @Override
    public String toString() {
        return getName() + ": " + PRICE;
    }

    @Override
    public boolean IsSpecial() {
        return true;
    }
}
