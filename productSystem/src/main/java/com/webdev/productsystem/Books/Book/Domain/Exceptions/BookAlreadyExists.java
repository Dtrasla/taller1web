package com.webdev.productsystem.Books.Book.Domain.Exceptions;

public class BookAlreadyExists extends RuntimeException{
    public BookAlreadyExists(String message) {
        super(message);
    }

}
