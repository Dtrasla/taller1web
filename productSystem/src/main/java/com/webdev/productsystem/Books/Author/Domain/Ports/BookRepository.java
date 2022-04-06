package com.webdev.productsystem.Books.Author.Domain.Ports;

import com.webdev.productsystem.Books.Book.Domain.Book;
import com.webdev.productsystem.Books.Book.Domain.ValueObjects.BookTitle;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    void save(Book book);
    void update(Book book);
    Optional<Book> find(BookTitle bookTitle);
//    Optional<Book> findByTitle(BookPrice email);
    Optional<List<Book>> all();
    void delete(Book book);
}
/*<bean id="UserFindAll" class="com.webdev.productsystem.Users.User.Application.All.UserFindAll" >
        <constructor-arg ref="UserRepository"/>
    </bean> */