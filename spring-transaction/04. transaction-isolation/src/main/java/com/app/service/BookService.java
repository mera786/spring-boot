package com.app.service;

import com.app.entity.Book;

public interface BookService {
    void updateBookName(Long id, String name);
    Book readBook(Long id);
}

