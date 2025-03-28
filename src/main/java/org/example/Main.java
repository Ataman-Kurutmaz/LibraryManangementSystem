package org.example;

import usecase.BookService;
import infrastructure.repositories.BookRepository;
import interface_adapters.controllers.BookController;

public class Main {
    public static void main(String[] args) {
        BookRepository bookRepository = new BookRepository();
        BookService bookService = new BookService(bookRepository);
        BookController kitapController = new BookController(bookService);
        kitapController.run();
    }
}
