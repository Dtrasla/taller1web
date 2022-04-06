package com.webdev.productsystem.Books.Book.Domain.All;

import com.webdev.productsystem.Books.Author.Domain.Ports.BookRepository;
import com.webdev.productsystem.Books.Book.Domain.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookFindAll {

    private BookRepository repository;

    public BookFindAll(BookRepository repository) {
        this.repository = repository;
    }

    public List<Book> execute() {
        List<Book> books = new ArrayList<Book>();
        Optional<List<Book>> optionalBooks = repository.all();
        if(optionalBooks.isPresent()) {
            books = optionalBooks.get();
        }
        return books;
    }
}
