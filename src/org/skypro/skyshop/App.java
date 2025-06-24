package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
       Product product1 = new SimpleProduct("молоко", 125.0);
       Product product2 = new SimpleProduct("яйцо 10 шт.", 90.0);
       Product product3 = new DiscountedProduct("мороженое", 80.0 , 20);
       Product product4 = new FixPriceProduct("кофе молотый");
       Product product5 = new DiscountedProduct("рулет", 100, 10);
       Product product6 = new SimpleProduct("хлеб", 55.0);

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