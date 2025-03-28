package interface_adapters.controllers;

import usecase.BookService;
import domain.entities.Book;

import java.util.List;
import java.util.Scanner;

public class BookController {

    private BookService bookService;
    private Scanner scanner;

    public BookController(BookService bookService) {
        this.bookService = bookService;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        int choose;
        do {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add Book");
            System.out.println("2. Show Books");
            System.out.println("3. Search Book by Title");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("Choose an option (1-6): ");
            choose = Integer.parseInt(scanner.nextLine());

            switch (choose) {
                case 1:
                    addBook();
                    break;
                case 2:
                    showBooks();
                    break;
                case 3:
                    findBook();
                    break;
                case 4:
                    borrowBook();
                    break;
                case 5:
                    returnBook();
                    break;
                case 6:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (choose != 6);
    }

    private void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author name: ");
        String author = scanner.nextLine();
        System.out.print("Enter book ISBN number: ");
        String ISBN = scanner.nextLine();
        bookService.addBook(title, author, ISBN);
        System.out.println("New book added.");
    }

    private void showBooks() {
        List<Book> books = bookService.showBooks();
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    private void findBook() {
        System.out.print("Enter the title of the book you are looking for: ");
        String title = scanner.nextLine();
        Book book = bookService.findBook(title);
        if (book != null) {
            System.out.println("Book found\n\n" + book);
        } else {
            System.out.println("Book not found.");
        }
    }

    private void borrowBook() {
        System.out.print("Enter the title of the book you want to borrow: ");
        String title = scanner.nextLine();
        bookService.borrowBook(title);
    }

    private void returnBook() {
        System.out.print("Enter the title of the book you want to return: ");
        String title = scanner.nextLine();
        bookService.returnBook(title);
    }
}
