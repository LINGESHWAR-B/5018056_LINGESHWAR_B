package com.example.bookstoreapi;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    private List<Book> books = new ArrayList<>();

    public BookController() {
        books.add(new Book(1, "The Great Gatsby", "F. Scott Fitzgerald"));
        books.add(new Book(2, "1984", "George Orwell"));
        books.add(new Book(3, "To Kill a Mockingbird", "Harper Lee"));
    }

    // Endpoint to get a book by ID with a custom HTTP status code
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK) // Custom status code for successful retrieval
    public Book getBookById(@PathVariable int id) {
        Optional<Book> book = books.stream().filter(b -> b.getId() == id).findFirst();
        if (book.isPresent()) {
            return book.get();
        } else {
            throw new BookNotFoundException(); // Custom exception to handle not found cases
        }
    }

    // Endpoint to create a new book with custom headers
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        books.add(book);
        
        // Create custom headers
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "Book created successfully");
        
        return new ResponseEntity<>(book, headers, HttpStatus.CREATED);
    }
}
