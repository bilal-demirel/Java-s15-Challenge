package com.library.app;

public interface IBook {
    long getID();
    String getTitle();
    String getAuthor();
    void displayBook();
    void updateBookBorrowStatus();
    void setAuthor(String author);
    void setName(String name);
    void setPrice(double price);
    double getPrice();
}
