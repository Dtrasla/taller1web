package com.webdev.productsystem.Books.Book.Domain.ValueObjects;

import com.webdev.productsystem.Shared.Domain.Exceptions.InvalidValue;
import com.webdev.productsystem.Shared.Domain.Aggregate.IntegerValueObject;

public class BookPrice extends IntegerValueObject {
    public BookPrice() {}

    public BookPrice(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) { negativeValue(value); }

    private void negativeValue(int value) {
        if(value < 0)
            throw new InvalidValue("Price has to be positive");
    }

    private void minimumPrice(int value) {
        if(value < 10000)
            throw new InvalidValue("Price has to be greater than 10000");
    }
}
