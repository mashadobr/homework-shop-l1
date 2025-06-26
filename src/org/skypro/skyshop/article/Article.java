package org.skypro.skyshop.article;

import org.skypro.skyshop.Searchable.Searchable;

public class Article implements Searchable {
    private final String titleArticle;
    private final String contentArticle;

    public Article(String titleAtricle, String contentArticle) {
        this.titleArticle = titleAtricle;
        this.contentArticle = contentArticle;
    }

    public String getTitleArticle() {
        return titleArticle;
    }

    public String getContentArticle() {
        return contentArticle;
    }

    @Override
    public String toString() {
        return titleArticle + "\n" + contentArticle;
    }


    @Override
    public String getSearchTerm() {
        return toString();
    }


    @Override
    public String getContentType() {
        return "ARTICLE";
    }
}
