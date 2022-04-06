package com.webdev.productsystem.Books.Book.Domain.ValueObjects;

import com.webdev.productsystem.Books.Book.Domain.Exceptions.InvalidLength;
//import com.webdev.productsystem.shared;
import com.webdev.productsystem.Shared.Domain.Exceptions.InvalidValue;
import com.webdev.productsystem.Shared.Domain.Aggregate.IntegerValueObject;
//com.webdev.productsystem.Shared.Domain.Aggregate.StringValueObject

import java.time.LocalDateTime;

public class BookYear extends IntegerValueObject {
    public BookYear() {}

    public BookYear(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        formatValue(value);
        lengthValue(value);
    }

    private void formatValue(int value) {
        if(value > LocalDateTime.now().getYear())
            throw new InvalidValue("Year cannot be above " + LocalDateTime.now().getYear());
    }

    private void lengthValue(int value) {
        if (String.valueOf(value).length() != 4)
            throw new InvalidLength("Year must have 4 characters");
    }
}
