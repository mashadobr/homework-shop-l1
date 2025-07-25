package org.skypro.skyshop.product;

import org.skypro.skyshop.Searchable.Searchable;

public abstract class Product implements Searchable {
    private final String name;

    public Product(String name) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя пользователя не может быть пустым");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public abstract double getPrice();

    public abstract boolean IsSpecial();

    @Override
    public String getSearchTerm() {
        return getName();
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }
}
