package com.webdev.productsystem.Books.Book.Domain.Exceptions;

public class InvalidLength extends RuntimeException{
    public InvalidLength(String message) { super(message); }
}
