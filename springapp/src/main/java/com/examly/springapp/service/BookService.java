package com.examly.springapp.service;

import org.springframework.stereotype.Service;

import com.examly.springapp.model.Book;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private List<Book> books = new ArrayList<>();

    public List<Book> getAllBooks() {
        return books;
    }

    public Book addBook(Book book) {
        // In a real-world scenario, you might want to generate a unique ID for the book
        books.add(book);
        return book;
    }
}
