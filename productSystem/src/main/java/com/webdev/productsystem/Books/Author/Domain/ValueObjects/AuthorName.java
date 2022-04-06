package com.webdev.productsystem.Books.Author.Domain.ValueObjects;

import com.webdev.productsystem.Shared.Domain.Aggregate.StringValueObject;
import com.webdev.productsystem.Shared.Domain.Exceptions.InvalidValue;

public class AuthorName extends StringValueObject {
    AuthorName() {}

    AuthorName(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) { invalidCharacter(value); }

    private void invalidCharacter(String value) {
        if(value.matches("[0-9]"))
            throw new InvalidValue("Author's last name cannot have numbers");
    }
}
