package org.skypro.skyshop.article;

import org.skypro.skyshop.Searchable.Searchable;

import java.util.Objects;

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
        return titleArticle;
    }


    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String getStringRepresentation() {
        return "имя объекта " + titleArticle + ": " + contentArticle + ", тип объекта: " + getContentType();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(titleArticle, article.titleArticle);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(titleArticle);
    }
}

