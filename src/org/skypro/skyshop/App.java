package org.skypro.skyshop;

import org.skypro.skyshop.Searchable.SearchEngine;
import org.skypro.skyshop.Searchable.Searchable;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.exception.BestResultNotFound;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.Set;

public class App {
    public static void main(String[] args) throws BestResultNotFound {
        //Create products
        Product product1 = new SimpleProduct("молоко", 125.0);
        Product product2 = new SimpleProduct("яйцо 10 шт.", 90.0);
        Product product3 = new DiscountedProduct("мороженое", 80.0, 20);
        Product product4 = new FixPriceProduct("кофе молотый");
        Product product5 = new DiscountedProduct("яйцо 20 шт", 180, 10);
        Product product6 = new SimpleProduct("хлеб", 55.0);

        //Create set for search
        SearchEngine test = new SearchEngine();
        //Добавление продуктов в список
        test.addSearchable(product1);
        test.addSearchable(product2);
        test.addSearchable(product3);
        test.addSearchable(product4);
        test.addSearchable(product5);
        //Create article and add to set
        Article articleCoffe = new Article("кофе ", "бодрит с утра");
        Article articleEggs = new Article("куриное яйцо", "продукт подходит для завтрака");
        Article articleCream = new Article("Увлажняющий крем",
                "Крем хорошо увлажняет кожу, что делает ее увлаженной.");
        Article articleGel = new Article("Увлажняющий гель",
                "Гель хорошо увлажняет кожу");
        Article articleLipstik = new Article("Увлажняющая помада",
                "Помамада хорошо наносится ");
        test.addSearchable(articleCoffe);
        test.addSearchable(articleEggs);
        test.addSearchable(articleCream);
        test.addSearchable(articleGel);
        test.addSearchable(articleLipstik);
        //Тестируем поиск по имени
        String search1 = "кофе";
        Set<Searchable> resultSearcheble1 = test.search(search1);
        System.out.println(resultSearcheble1);
        search1 = "яйцо";
        Set<Searchable> resultSearcheble2 = test.search(search1);
        System.out.println(resultSearcheble2);
        search1 = "Увлаж";
        Set<Searchable> resultSearcheble3 = test.search(search1);
        System.out.println(resultSearcheble3);


    }
}

