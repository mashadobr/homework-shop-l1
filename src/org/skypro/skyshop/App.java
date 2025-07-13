package org.skypro.skyshop;

import org.skypro.skyshop.exception.BestResultNotFound;
import org.skypro.skyshop.Searchable.SearchEngine;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) throws BestResultNotFound {
//        Product product1 = new SimpleProduct("молоко", 125.0);
//        Product product2 = new SimpleProduct("яйцо 10 шт.", 90.0);
//        Product product3 = new DiscountedProduct("мороженое", 80.0, 20);
//        Product product4 = new FixPriceProduct("кофе молотый");
//        Product product5 = new DiscountedProduct("яйца 20 шт", 180, 10);
//        Product product6 = new SimpleProduct("хлеб", 55.0);
//
//        ProductBasket basket1 = new ProductBasket();
//        basket1.addProduct(product1);
//        basket1.addProduct(product2);
//        basket1.addProduct(product3);
//        basket1.addProduct(product4);
//        basket1.addProduct(product5);
//        basket1.addProduct(product6);
//        basket1.printBasket();
//        System.out.println("Стоимость корзины: " + basket1.countBasketCost());
//        boolean findProduct1 = basket1.checkProductInBasket("мороженое");
//        System.out.println(findProduct1);
//        findProduct1 = basket1.checkProductInBasket("булка");
//        System.out.println(findProduct1);
//        basket1.cleanBasket();
//        basket1.printBasket();
//        System.out.println("Стоимость корзины: " + basket1.countBasketCost());
//        findProduct1 = basket1.checkProductInBasket("булка");
//        System.out.println(findProduct1);
//        SearchEngine test = new SearchEngine(7);
//        test.addSearchable(product1);
//        test.addSearchable(product2);
//        test.addSearchable(product3);
//        test.addSearchable(product4);
//        test.addSearchable(product5);
//        Article articleCoffe = new Article("кофе молотый", "бодрит с утра");
//        Article articleEggs = new Article("яйцо", "продукт подходит для завтрака");
//        test.addSearchable(articleCoffe);
//        test.addSearchable(articleEggs);
//        test.addSearchable(product6);
//        test.pintSearchables();
//        Searchable[] resultSearcheble1 = test.search("кофе");
//        test.printResult(resultSearcheble1);
//        Searchable[] resultSearcheble2 = test.search("яйцо");
//        test.printResult(resultSearcheble2);
        try {
            Product product7 = new SimpleProduct("   ", 10);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            Product product8 = new SimpleProduct("масло", -10);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            Product product9 = new DiscountedProduct("тесто", 100, 120);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        Article articleCream = new Article("Увлажняющий крем",
                "Крем хорошо увлажняет кожу, что делает ее увлаженной.");
        Article articleGel = new Article("Увлажняющий гель",
                "Гель хорошо увлажняет кожу");
        Article articleLipstik = new Article("Увлажняющая помада",
                "Помамада хорошо наносится ");
        SearchEngine testForSearch = new SearchEngine(3);
        testForSearch.addSearchable(articleCream);
        testForSearch.addSearchable(articleGel);
        testForSearch.addSearchable(articleLipstik);

        System.out.println("Тестируем поиск getBestResult");
        String search1 = "увлаж";
        try {
            System.out.println("Результат для " + search1 + ": " + (testForSearch.getBestResult(search1)));
        } catch (BestResultNotFound e) {
            System.out.println("для " + search1 + " на нашлось подходяшей статьи");
        }
        search1 = "hello";
        try {
            System.out.println("Результат для " + search1 + ": " + (testForSearch.getBestResult(search1)));
        } catch (BestResultNotFound e) {
            System.out.println("для " + search1 + " на нашлось подходяшей статьи");
        }
    }
}

