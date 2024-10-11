package com.library.app;
import java.util.Date;

public class Book implements IBook{
    private long bookID;
    private String author;
    private String name;
    private String category;
    private double price;
    private boolean isBorrowed;
    private Date dateOfBorrow;
    private Member borrower;

    public Book(long bookID, String author, String name, String category, double price) {
        this.bookID = bookID;
        this.author = author;
        this.name = name;
        this.category = category;
        this.price = price;
        this.isBorrowed = false;
    }

    @Override
    public long getID(){
        return this.bookID;
    }
    @Override
    public String getTitle() {
        return this.name;
    }

    @Override
    public String getAuthor() {
        return this.author;
    }
    public boolean isBorrowed() {
        return isBorrowed;
    }
    @Override
    public void displayBook() {
        System.out.println("Book Title: " + this.name);
        System.out.println("Book Author: " + this.author);
        System.out.println("Book Price: " + this.price);
    }

    @Override
    public void updateBookBorrowStatus() {
        this.isBorrowed = !this.isBorrowed;
    }
    @Override
    public void setAuthor(String author){
        this.author = author;
    }
    @Override
    public void setName(String name){
        this.name = name;
    }
    @Override
    public void setPrice(double price){
        this.price = price;
        System.out.println("[" + this.getTitle() + "]'s price changed as: " + price);
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Member getBorrower(){
        return this.borrower;
    }
    public void setBorrower(Member borrower){
        this.borrower = borrower;
    }
    public Date getDateOfBorrow() {
        return dateOfBorrow;
    }

    public void setDateOfBorrow(Date dateOfBorrow) {
        this.dateOfBorrow = dateOfBorrow;
    }
    @Override
    public String toString(){
        return this.name + ", " + this.author;
    }
    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || this.getClass() != obj.getClass()) return false;
        Book myBook = (Book) obj;
        return this.getID() == myBook.getID();
    }
}
