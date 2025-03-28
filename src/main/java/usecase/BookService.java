package usecase;

import domain.entities.Book;
import infrastructure.repositories.BookRepository;

import java.util.List;

public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(String title, String author, String ISBN) {
        Book newBook = new Book(title, author, ISBN);
        bookRepository.addBook(newBook);
    }

    public List<Book> showBooks() {
        return bookRepository.getAllBooks();
    }

    public Book findBook(String title) {
        return bookRepository.getByTitle(title);
    }

    public void borrowBook(String title) {
        Book book = bookRepository.getByTitle(title);
        if (book != null) {
            try {
                book.take();
                System.out.println("Book borrowed successfully.");
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Book not found.");
        }
    }

    public void returnBook(String title) {
        Book book = bookRepository.getByTitle(title);
        if (book != null) {
            try {
                book.giveBack();
                System.out.println("Book returned successfully.");
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Book not found.");
        }
    }
}
