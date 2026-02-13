package com.app.service.impl;

import com.app.entity.Book;
import com.app.repository.BookRepository;
import com.app.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    // 🔥 Transaction A (Write)
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void updateBookName(Long id, String name) {
        Book book = bookRepository.findById(id).orElseThrow();
        book.setBookName(name);
        bookRepository.save(book);

        try {
            Thread.sleep(15000); // simulate long transaction
        } catch (Exception e) {}
    }

    // 🔥 Transaction B (Read)
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public Book readBook(Long id) {
        return bookRepository.findById(id).orElseThrow();
    }


    /*
    👉 Tum yaha dono method A and B ke Isolation.READ_COMMITTED ko change karke
READ_UNCOMMITTED, REPEATABLE_READ, SERIALIZABLE test karoge.
     */
}

