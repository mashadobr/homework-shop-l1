package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private Map<String, List<Product>> basket;

    public ProductBasket() {
        this.basket = new HashMap<>();
    }

    public void addProduct(Product product) {
        basket.computeIfAbsent(product.getName(), k -> new LinkedList<>()).add(product);
    }

    public double countBasketCost() {
        double basketCost = 0;
        for (Map.Entry<String, List<Product>> entry : basket.entrySet()) {
            for (Product product : entry.getValue()) {
                basketCost = basketCost + product.getPrice();
            }
        }
        return basketCost;
    }

    public double countSpecialProducts() {
        int counterSpecialProducts = 0;
        for (Map.Entry<String, List<Product>> entry : basket.entrySet()) {
            for (Product product : entry.getValue()) {
                if (product.IsSpecial()) {
                    counterSpecialProducts++;
                }
            }
        }
        return counterSpecialProducts;
    }

    public void printBasket() {
        System.out.println("Содержание корзины:");
        if (basket.isEmpty()) {
            System.out.println("в корзине пусто");
        }
        for (Map.Entry<String, List<Product>> entry : basket.entrySet()) {
            for (Product product : entry.getValue())
                System.out.println(product);
        }
        double totalCost = countBasketCost();
        System.out.println("Итого: " + totalCost);
        System.out.println("Специальных товаров: " + countSpecialProducts());

    }

    public boolean checkProductInBasket(String nameProduct) {
        return basket.containsKey(nameProduct);
    }

    public void cleanBasket() {
        basket.clear();
    }

    public List<Product> removeByMame(String nameProduct) {
        if (basket.containsKey(nameProduct)) {
            return basket.remove(nameProduct);
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProductBasket basket1 = (ProductBasket) o;
        return Objects.equals(basket, basket1.basket);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(basket);
    }
}








