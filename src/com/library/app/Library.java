package com.library.app;

import java.util.*;

public class Library implements ILibrary{
    private List<Book> books;
    private List<Member> members;
    private Map<Book, Member> bookBorrowerMap;
    private Map<Member, Book> memberBillMap;

    public Library() {
        this.books = new LinkedList<>();
        this.bookBorrowerMap = new HashMap<>();
        this.memberBillMap = new HashMap<>();
    }
    public Map<Book, Member> getBookBorrowerMap() {
        return bookBorrowerMap;
    }

    public void setBookBorrowerMap(Map<Book, Member> bookBorrowerMap) {
        this.bookBorrowerMap = bookBorrowerMap;
    }

    public Map<Member, Book> getMemberBillMap() {
        return memberBillMap;
    }

    public void setMemberBillMap(Map<Member, Book> memberBillMap) {
        this.memberBillMap = memberBillMap;
    }
    @Override
    public void addBillToMember(Member member, Book book){
        this.memberBillMap.put(member, book);
    }
    @Override
    public void refundBillToMember(Member member, Book book){
        Book borrowedBook = memberBillMap.get(member);
        if(book.equals(borrowedBook)) memberBillMap.remove(member, book);
    }
    @Override
    public void displayBills(){
        System.out.println(memberBillMap);
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
        System.out.println("[" + book.getTitle() + "] added to our library.");
    }

    @Override
    public void removeBookByID(long bookID) {
        Iterator<Book> iter = this.books.iterator();
        while(iter.hasNext()){
            Book myBook = iter.next();
            if(bookID == myBook.getID()){
                iter.remove();
                System.out.println("[" + myBook.getTitle() + "] removed from our library.");
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
        int checker = 0;
        Iterator<Book> iter = this.books.iterator();
        while(iter.hasNext()){
            Book myBook = iter.next();
            if(category.equals(myBook.getCategory())){
                iter.remove();
                checker++;
                System.out.println(checker + ". [" + myBook.getTitle() + "] removed from our library.");
            }
        }
        if(checker == 0) System.out.println("There is not any book in our library belong to this category.");
    }
    @Override
    public void displayBookBorrowerMap(){
        for(Map.Entry<Book, Member> log : this.getBookBorrowerMap().entrySet()){
            Book bookLog = log.getKey();
            Member memberLog = log.getValue();
            System.out.println("Book Title: "  + bookLog + " Book Borrower: " + memberLog);
        }
    }
    @Override
    public void displayBooks(){
        int counter = 1;
        for(Book book : this.books){
            System.out.println(counter + ". " + book.getTitle());
            counter++;
        }
    }
    @Override
    public void displayBookByID(long bookID){
        int checker = 0;
        for(Book book : this.books){
            if(bookID == book.getID()){
                System.out.println("Book with ID: " + bookID + " is [" + book.getTitle() + "].");
                checker++;
            }
        }
        if(checker == 0) System.out.println("There is not any book in our library with this ID.");
    }
    @Override
    public void displayBooksByAuthor(String author){
        int checker = 0;
        for(Book book : this.books){
            if(author.equals(book.getAuthor())){
                if(checker == 0) System.out.println(author + "'s book/books listed below:\n"
                        + (checker+1) + ".[" + book.getTitle() + "]");
                else System.out.println((checker+1) + ".[" + book.getTitle() + "]");
                checker++;
            }
        }
        if(checker == 0) System.out.println("There is not any book in our library belong to this author.");
    }
    @Override
    public void displayBookByName(String name){
        int checker = 0;
        for(Book book : this.books){
            if(name.equals(book.getTitle())){
                System.out.println(book);
                checker++;
            }
        }
        if(checker == 0) System.out.println("There is not any book in our library belong to this name.");
    }
    @Override
    public void displayBookByCategory(String category){
        int checker = 0;
        for(Book book : this.books){
            if(category.equals(book.getCategory())){
                if(checker == 0) System.out.println("Book/books belong to this category listed below:\n"
                        + (checker+1) + ".[" + book.getTitle() + "]");
                else System.out.println((checker+1) + ".[" + book.getTitle() + "]");
                checker++;
            }
        }
        if(checker == 0) System.out.println("There is not any book in our library belong to this category.");
    }
}
