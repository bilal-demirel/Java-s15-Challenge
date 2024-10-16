package com.library.app;

import java.util.List;

public interface ILibrary {
    public void addBook(Book book);
    public void removeBookByID(long bookID);
    public List<Book> getBooksByAuthor(String author);
    public List<Book> getBooksByCategory(String category);
    public Book getBookByName(String name);
    public Book getBookByID(long bookID);
    void removeByCategory(String category);
    void displayBookBorrowerMap();
    void displayBooks();
    void displayBookByID(long bookID);
    void displayBooksByAuthor(String author);
    void displayBookByName(String name);
    void displayBookByCategory(String category);
    void addBillToMember(Member member, Book book);
    void refundBillToMember(Member member, Book book);
    void displayBills();
}
