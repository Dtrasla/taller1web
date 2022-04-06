package com.webdev.productsystem.Books.Book.Domain.ValueObjects;

import com.webdev.productsystem.Books.Book.Domain.Exceptions.InvalidLength;
import com.webdev.productsystem.Shared.Domain.Aggregate.StringValueObject;

public class BookDescription extends StringValueObject {
    public BookDescription() {}

    public BookDescription(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) { lengthValue(value); }

    private void lengthValue(String value) {
        if(value.length() > 200)
            throw new InvalidLength("Description must contain less than 200 characters");
    }
}
