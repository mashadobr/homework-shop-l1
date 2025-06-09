package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        Product product1 = new Product("молоко", 125.0);
        Product product2 = new Product("яйцо 10 шт.", 90.0);
        Product product3 = new Product("мороженое", 80.0);
        Product product4 = new Product("кофе растворим", 125.5);
        Product product5 = new Product("печенье", 100.0);
        Product product6 = new Product("хлеб", 55.0);

        ProductBasket basket1 = new ProductBasket();
        basket1.addProduct(product1);
        basket1.addProduct(product2);
        basket1.addProduct(product3);
        basket1.addProduct(product4);
        basket1.addProduct(product5);
        basket1.addProduct(product6);
        basket1.printBasket();
        System.out.println("Стоимость корзины: " + basket1.countBasketCost());
        boolean findProduct1 = basket1.checkProductInBasket("мороженое");
        System.out.println(findProduct1);
        findProduct1 = basket1.checkProductInBasket("булка");
        System.out.println(findProduct1);
        basket1.cleanBasket();
        basket1.printBasket();
        System.out.println("Стоимость корзины: " + basket1.countBasketCost());
        findProduct1 = basket1.checkProductInBasket("булка");
        System.out.println(findProduct1);


    }
}