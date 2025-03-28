package domain.entities;

public class Book {
    private String title;
    private String author;
    private String ISBN;
    private boolean isBorrowed;

    public Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.isBorrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void take() {
        if (!isBorrowed) {
            this.isBorrowed = true;
        } else {
            throw new IllegalStateException("This book has already been borrowed.");
        }
    }

    public void giveBack() {
        if (isBorrowed) {
            this.isBorrowed = false;
        } else {
            throw new IllegalStateException("This book has already been returned.");
        }
    }

    @Override
    public String toString() {
        return "Title: " + title + "\n" + "Author: " + author + "\n" + "ISBN: " + ISBN + "\n" + "Status: " + (isBorrowed ? "Borrowed" : "Available");
    }
}
