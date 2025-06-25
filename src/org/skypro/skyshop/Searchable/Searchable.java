package org.skypro.skyshop.Searchable;

public interface Searchable {
    String searchTerm();
    String getContentType();
    default String getStringRepresentation(){
        return "имя объекта " + searchTerm() + ", тип объекта: " +  getContentType();
    }
}
