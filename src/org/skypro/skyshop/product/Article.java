package org.skypro.skyshop.product;

import org.skypro.skyshop.Searchable.Searchable;

public class Article implements Searchable {
    public final String titleArticle;
    public final String contentArticle;

    public Article(String titleAtricle, String contentArticle) {
        this.titleArticle = titleAtricle;
        this.contentArticle = contentArticle;
    }

    @Override
    public String toString() {
        return titleArticle + "\n" + contentArticle;
    }


    @Override
    public String searchTerm() {
        return toString();
    }


    @Override
    public String getContentType() {
        return "ARTICLE";
    }
}
