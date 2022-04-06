package com.webdev.productsystem.Books.Application.Create;

//import com.example.library.Books.*;
import com.webdev.productsystem.Books.Author.Domain.Ports.BookRepository;
import com.webdev.productsystem.Books.Book.Domain.Book;
import com.webdev.productsystem.Books.Book.Domain.ValueObjects.BookDescription;
import com.webdev.productsystem.Books.Book.Domain.ValueObjects.BookPrice;
import com.webdev.productsystem.Books.Book.Domain.ValueObjects.BookTitle;
import com.webdev.productsystem.Books.Book.Domain.ValueObjects.BookYear;

public class BookCreator {
    private BookRepository repository;

    public BookCreator(BookRepository repository) {
        this.repository = repository;
    }

    public void execute(String bookTitle,  String bookDescription, int bookPrice, int bookYear) {
        Book book = Book.create(new BookTitle(bookTitle), new BookDescription(bookDescription), new BookPrice(bookPrice),new BookYear(bookYear));
        repository.save(book);
    }
}
