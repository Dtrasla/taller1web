package com.webdev.productsystem.Books.Book.Domain.All;

import com.webdev.productsystem.Books.Book.Domain.Book;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class BookFindAllResponse {
    
    private List<Book> books;

    public BookFindAllResponse(List<Book> books) {
        this.books = books;
    }

    public List<HashMap<String, Object>> response() {
        List<HashMap<String, Object>> response = books.stream().map(book-> book.data()).collect(Collectors.toList());
        return response;
    }
}
