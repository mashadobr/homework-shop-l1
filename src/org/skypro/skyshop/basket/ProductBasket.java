package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private Product[] products;
    int counter;

    public int getCounter() {
        return counter;
    }

    public ProductBasket() {
        this.products = new Product[5];
    }

    public void addProduct(Product product) {
        if (counter >= 5) {
            System.out.println("Невозможно добавить продукт");
        } else {
            products[counter] = product;
            counter++;
        }
    }

    public double countBasketCost() {
        double basketCost = 0;
        for (int i = 0; i < counter; ++i) {
            basketCost = +basketCost + products[i].getPrice();
        }
        return basketCost;
    }

    public void printBasket() {
        if (counter == 0) {
            System.out.println("в корзине пусто");
        }
        for (int i = 0; i < counter; ++i) {
            Product product = products[i];
            System.out.println(product.getName() + ":" + product.getPrice());
        }
        double totalCost = countBasketCost();
        System.out.println("Итого: " + totalCost);
    }

    public boolean checkProductInBasket(String nameProduct) {
        for (int i = 0; i < counter; ++i) {
            Product product = products[i];
            if (product.getName().equals(nameProduct)) {
                return true;
            }
        }
        return false;
    }

    public void cleanBasket() {
        for (int i = 0; i < counter; ++i) {
            products[i] = null;
            counter = 0;
        }
    }
}







