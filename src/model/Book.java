package model;

public class Book {
    private String title;
    private String author;
    private String category;
    private double price;
    private int stock;
    private String isbn;

    public Book(String title, String author, String category, double price, int stock, String isbn) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.price = price;
        this.stock = stock;
        this.isbn = isbn;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }
    public String getIsbn() { return isbn; }

    public String toFileString() {
        return title + "," + author + "," + category + "," + price + "," + stock + "," + isbn;
    }

    public static Book fromFileString(String line) {
        String[] parts = line.split(",");
        if (parts.length != 6) {
            return null;
        }
        try {
            String title = parts[0];
            String author = parts[1];
            String category = parts[2];
            double price = Double.parseDouble(parts[3]);
            int stock = Integer.parseInt(parts[4]);
            String isbn = parts[5];
            return new Book(title, author, category, price, stock, isbn);
        } catch (NumberFormatException ex) {
            return null;
        }
    }
}
