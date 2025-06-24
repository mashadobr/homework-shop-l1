package org.skypro.skyshop.product;

public class DiscountedProduct extends Product{
    double price;
    int sale;

    public DiscountedProduct(String name, double price, int sale) {
        super(name);
        this.price = price;
        this.sale = sale;
    }

    @Override
    public double getPrice() {
        return (price * (double) sale / 100);
    }

    @Override
    public String toString() {
        return getName()+": "+getPrice() +
                " (скидка " + sale + "% )";
    }

    @Override
    public boolean IsSpecial() {
        return true;
    }
}
