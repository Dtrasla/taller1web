package com.webdev.productsystem.Books.Book.Domain;

import com.webdev.productsystem.Books.Book.Domain.ValueObjects.BookDescription;
import com.webdev.productsystem.Books.Book.Domain.ValueObjects.BookPrice;
import com.webdev.productsystem.Books.Book.Domain.ValueObjects.BookTitle;
import com.webdev.productsystem.Books.Book.Domain.ValueObjects.BookYear;

import java.util.HashMap;

public class Book {
    private BookTitle title;
    private BookDescription description;
    private BookPrice price;
    private BookYear year;

    public Book(BookTitle title, BookDescription description, BookPrice price, BookYear year) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.year = year;
    }

    public static Book create(BookTitle title, BookDescription description, BookPrice price, BookYear year) {
        return new Book(
                title,
                description,
                price,
                year
        );
    }

    public HashMap<String, Object> data() {
        return new HashMap<>() {{
            put("title", title.value());
            put("description", description.value());
            put("price", price.value());
            put("year", year.value());
        }};
    }
}
