package com.library.app;

public interface IMember {
    void borrowBookByBook(Library library, Book book);
    void borrowBookByName(String bookName);
    void returnBook(Library library, Book book);
}
