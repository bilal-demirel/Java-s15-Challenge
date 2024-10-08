package com.library.app;

import java.util.*;

public class Library implements ILibrary{
    private List<Book> books;
    private List<Member> members;
    private Map<Book, Member> bookBorrowerMap;

    public Library() {
        this.books = new LinkedList<>();
        this.bookBorrowerMap = new HashMap<>();
    }
    public Map<Book, Member> getBookBorrowerMap() {
        return bookBorrowerMap;
    }

    public void setBookBorrowerMap(Map<Book, Member> bookBorrowerMap) {
        this.bookBorrowerMap = bookBorrowerMap;
    }

    public List<Book> getBooks(){
        return this.books;
    }
    public List<Member> getMembers(){
        return this.members;
    }

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public void removeBookByID(long bookID) {
        for(Book book : this.books){
            if(bookID == book.getID()){
                this.books.remove(book);
            }
        }
    }

    @Override
    public List<Book> getBooksByAuthor(String author) {
        List<Book> authorBooks = new LinkedList<>();
        for(Book book : this.books){
            if(author.equals(book.getAuthor())){
                authorBooks.add(book);
            }
        }
        return authorBooks;
    }
    @Override
    public List<Book> getBooksByCategory(String category){
        List<Book> categoryBook = new LinkedList<>();
        for(Book book : this.books){
            if(category.equals(book.getCategory())){
                categoryBook.add(book);
            }
        }
        return categoryBook;
    }
    @Override
    public Book getBookByName(String name) {
        for(Book book : this.books){
            if(name.equals(book.getTitle())){
                return book;
            }
        }
        return null;
    }

    @Override
    public Book getBookByID(long bookID) {
        for(Book book : this.books){
            if(bookID == book.getID()){
                return book;
            }
        }
        return null;
    }
    @Override
    public void removeByCategory(String category){
        Iterator<Book> iter = this.books.iterator();
        while(iter.hasNext()){
            Book myBook = iter.next();
            if(category.equals(myBook.getCategory())){
                iter.remove();
            }
        }
    }
    @Override
    public void displayBookBorrowerMap(Library library){
        for(Map.Entry<Book, Member> log : library.getBookBorrowerMap().entrySet()){
            Book bookLog = log.getKey();
            Member memberLog = log.getValue();
            System.out.println("Kitap: "  + bookLog + "\n" + memberLog + "\n");
        }
    }
}
