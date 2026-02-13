package com.app.controller;

import com.app.entity.Book;
import com.app.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // Transaction A
    @PutMapping("/{id}")
    public String updateBook(@PathVariable Long id, @RequestParam String name) {
        bookService.updateBookName(id, name);
        return "Updated";
    }

    // Transaction B
    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        return bookService.readBook(id);
    }
}

