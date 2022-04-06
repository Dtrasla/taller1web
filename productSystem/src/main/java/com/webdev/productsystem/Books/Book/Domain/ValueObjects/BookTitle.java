package com.webdev.productsystem.Books.Book.Domain.ValueObjects;

import com.webdev.productsystem.Books.Book.Domain.Exceptions.InvalidLength;
import com.webdev.productsystem.Shared.Domain.Aggregate.StringValueObject;

public class BookTitle extends StringValueObject {

    public BookTitle() {}

    public BookTitle(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) { lengthValue(value); }

    private void lengthValue(String value) {
        if(value.length() < 5 || value.length() > 100)
            throw new InvalidLength("Title must has to be between 5 and 100 characters");
    }
}
