package com.webdev.productsystem.Books.Author.Domain;

import com.webdev.productsystem.Books.Author.Domain.ValueObjects.AuthorLastName;
import com.webdev.productsystem.Books.Author.Domain.ValueObjects.AuthorName;
//com.webdev.productsystem.Shared.Domain.Aggregate.StringValueObject
import java.util.HashMap;

public class Author {
    private AuthorName name;
    private AuthorLastName lastName;

    public Author(AuthorName name, AuthorLastName lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public static Author create(AuthorName name, AuthorLastName lastName) {
        return new Author(
                name,
                lastName
        );
    }

    public HashMap<String, Object> data() {
        return new HashMap<>() {{
            put("name", name.value());
            put("lastName", lastName.value());
        }};
    }
}
