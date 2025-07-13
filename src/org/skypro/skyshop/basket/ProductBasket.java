package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductBasket {
    private List<Product> products;
    int counter;

    public int getCounter() {
        return counter;
    }

    public ProductBasket() {
        this.products = new LinkedList<>();
    }

    public void addProduct(Product product) {
           products.add(product);
    }

    public double countBasketCost() {
        double basketCost = 0;
        for (Product basketProduct: products) {
            basketCost = +basketCost + basketProduct.getPrice();
        }
        return basketCost;
    }

    public double countSpecialProducts() {
        int counterSpecialProducts = 0;
        for (Product basketProduct: products) {
            if (basketProduct.IsSpecial()) {
                counterSpecialProducts++;
            }
        }
        return counterSpecialProducts;

    }

    public void printBasket() {
        System.out.println("Содержание корзины:");
        if (products.isEmpty()) {
            System.out.println("в корзине пусто");
        }
        for (Product basketProduct: products) {
            System.out.println(basketProduct);
        }
        double totalCost = countBasketCost();
        System.out.println("Итого: " + totalCost);
        System.out.println("Специальных товаров: " + countSpecialProducts());

    }

    public boolean checkProductInBasket(String nameProduct) {
        for (Product basketProduct: products) {
            if (basketProduct.getName().equals(nameProduct)) {
                return true;
            }
        }
        return false;
    }

    public void cleanBasket() {
            products.clear();
    }
    public void  removeByMame(String nameProduct) {
        List<Product> deleteProducts= new LinkedList<> ();
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product basketProduct = iterator.next();
            if (basketProduct.getName().contains(nameProduct)) {
                deleteProducts.add(basketProduct);
                iterator.remove();
            }
            }
        if (deleteProducts.isEmpty()){
            System.out.println("Список удаленных продуктов пуст");
        }
        else {
            System.out.println(deleteProducts);
        }
    }
}







