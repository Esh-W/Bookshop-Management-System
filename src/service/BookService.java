package service;

import model.Book;
import java.util.ArrayList;
import java.util.List;

public class BookService {
    private static final String FILE_NAME = "books.txt";

    public static void saveBook(Book book) {
        FileHandler.writeLineToFile(FILE_NAME, book.toFileString());
    }

    public static List<Book> getAllBooks() {
        List<String> lines = FileHandler.readLinesFromFile(FILE_NAME);
        List<Book> books = new ArrayList<>();

        for (String line : lines) {
            Book book = Book.fromFileString(line);
            if (book != null) {
                books.add(book);
            }
        }
        return books;
    }

    public static void saveAllBooks(List<Book> books) {
        List<String> lines = new ArrayList<>();
        for (Book book : books) {
            lines.add(book.toFileString());
        }
        FileHandler.writeLinesToFile(FILE_NAME, lines);
    }

    public static boolean upsertBook(Book book) {
        List<Book> books = getAllBooks();
        boolean updated = false;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getIsbn().equals(book.getIsbn())) {
                books.set(i, book);
                updated = true;
                break;
            }
        }
        if (!updated) {
            books.add(book);
        }
        saveAllBooks(books);
        return updated;
    }

    public static boolean deleteBookByIsbn(String isbn) {
        List<Book> books = getAllBooks();
        boolean removed = books.removeIf(book -> book.getIsbn().equals(isbn));
        if (removed) {
            saveAllBooks(books);
        }
        return removed;
    }
}