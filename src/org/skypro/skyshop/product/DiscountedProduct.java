package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    double price;
    int sale;

    public DiscountedProduct(String name, double price, int sale) {
        super(name);
        if (price < 1) {
            throw new IllegalArgumentException("Цена не может быть меньше 0");
        }
        if (sale < 0 || sale > 100) {
            throw new IllegalArgumentException("Процент должен быть числом в диапазоне от 0 до 100 включительно");
        }
        this.price = price;
        this.sale = sale;
    }

    @Override
    public double getPrice() {
        return (price * (double) sale / 100);
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice() +
                " (скидка " + sale + "% )";
    }

    @Override
    public boolean IsSpecial() {
        return true;
    }
}
