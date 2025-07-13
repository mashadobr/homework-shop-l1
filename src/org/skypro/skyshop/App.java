package org.skypro.skyshop;

import org.skypro.skyshop.Searchable.SearchEngine;
import org.skypro.skyshop.Searchable.Searchable;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.exception.BestResultNotFound;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.List;

public class App {
    public static void main(String[] args) throws BestResultNotFound {
        Product product1 = new SimpleProduct("молоко", 125.0);
        Product product2 = new SimpleProduct("яйцо 10 шт.", 90.0);
        Product product3 = new DiscountedProduct("мороженое", 80.0, 20);
        Product product4 = new FixPriceProduct("кофе молотый");
        Product product5 = new DiscountedProduct("яйцо 20 шт", 180, 10);
        Product product6 = new SimpleProduct("хлеб", 55.0);

        ProductBasket basket1 = new ProductBasket();
        basket1.addProduct(product1);
        basket1.addProduct(product2);
        basket1.addProduct(product3);
        basket1.addProduct(product4);
        basket1.addProduct(product5);
        basket1.addProduct(product6);
        //Удаление продкукта из корзины по назаванию
        System.out.println("Test method remove by name");
        basket1.removeByMame("яйцо");
        basket1.printBasket();
        basket1.removeByMame("манго");
        basket1.printBasket();
        //Создание списка для поиска
        SearchEngine test = new SearchEngine();
        //Добавление продуктов в список
        test.addSearchable(product1);
        test.addSearchable(product2);
        test.addSearchable(product3);
        test.addSearchable(product4);
        test.addSearchable(product5);
        //Создание статей и добавлние в список
        Article articleCoffe = new Article("кофе молотый", "бодрит с утра");
        Article articleEggs = new Article("яйцо", "продукт подходит для завтрака");
        test.addSearchable(articleCoffe);
        test.addSearchable(articleEggs);
        //Распечатываем список
        test.pintSearchables();
        //Тестируем поиск по имени
        String search1 = "кофе";
        List<Searchable> resultSearcheble1 = test.search(search1);
        test.printResult(resultSearcheble1);
        search1 = "яйцо";
        List<Searchable> resultSearcheble2 = test.search(search1);
        test.printResult(resultSearcheble2);

        Article articleCream = new Article("Увлажняющий крем",
                "Крем хорошо увлажняет кожу, что делает ее увлаженной.");
        Article articleGel = new Article("Увлажняющий гель",
                "Гель хорошо увлажняет кожу");
        Article articleLipstik = new Article("Увлажняющая помада",
                "Помамада хорошо наносится ");
        SearchEngine testForSearch = new SearchEngine();
        testForSearch.addSearchable(articleCream);
        testForSearch.addSearchable(articleGel);
        testForSearch.addSearchable(articleLipstik);

        System.out.println("Тестируем поиск getBestResult");
        search1 = "увлаж";
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

