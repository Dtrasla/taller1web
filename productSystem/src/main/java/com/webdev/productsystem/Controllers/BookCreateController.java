package com.webdev.productsystem.Controllers;

import com.webdev.productsystem.Books.Application.Create.BookCreator;
import com.webdev.productsystem.Books.Book.Domain.Exceptions.InvalidLength;
import com.webdev.productsystem.Books.Book.Domain.Book;
import com.webdev.productsystem.Books.Book.Domain.All.BookFindAll;
import com.webdev.productsystem.Books.Book.Domain.All.BookFindAllResponse;
import com.webdev.productsystem.Books.Book.Domain.Exceptions.BookAlreadyExists;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.List;

@RestController
@Tag(name = "Book", description = "Book REST API")
@RequestMapping(value = "/book")
public class BookCreateController {
    @Autowired
    private BookFindAll creator;

    @GetMapping(value = "/all")
    public ResponseEntity<List<HashMap<String, Object>>> execute() {
        BookFindAllResponse response = new BookFindAllResponse(creator.execute());
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }
/*
    @Operation(summary = "Create a new Book", description = "Create a new Book in the system", tags = {"Book"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Book created"),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content(schema = @Schema(implementation = Errors.class))),
            @ApiResponse(responseCode = "409", description = "Book already exist", content = @Content(schema = @Schema(implementation = Errors.class)))
    })
    
    @PostMapping(value = "/create")
    public ResponseEntity execute(@RequestBody BookCreatorRequest request) {
        creator.execute(request.getTitle(), request.getDescription(), request.getPrice(), request.getYear());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @ExceptionHandler(value = {InvalidLength.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<HashMap> handleBadRequest(RuntimeException exception) {
        HashMap<String, String> response = new HashMap<>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(BookAlreadyExists.class)
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public ResponseEntity<HashMap> handleDuplicatedBook(RuntimeException exception) {
        HashMap<String, String> response = new HashMap<>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }
*/
    static class BookCreatorRequest {
        @Schema(description = "Book Title", example = "Lord of The Rings")
        private String title;

        @Schema(description = "Book Description", example = "Descripcion del libro xd")
        private String description;

        @Schema(description = "Book Price", example = "50000")
        private int price;

        @Schema(description = "Book Year", example = "2020")
        private int year;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }
    }

}
