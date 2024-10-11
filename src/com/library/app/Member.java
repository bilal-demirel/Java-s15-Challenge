package com.library.app;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Member extends Library implements IMember{
    private long memberID;
    private String name;
    private int borrowedBookCounter;
    private Map<String, Date> borrowedBooks;

    public Member(long memberID, String name) {
        this.memberID = memberID;
        this.name = name;
        this.borrowedBookCounter = 0;
        this.borrowedBooks = new HashMap<>();
    }

    public long getMemberID() {
        return memberID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getBorrowedBookCounter() {
        return borrowedBookCounter;
    }
    public void setBorrowedBookCounter(int borrowedBookCounter) {
        this.borrowedBookCounter = borrowedBookCounter;
    }
    @Override
    public void borrowBookByBook(Library library, Book book){
        if(book.isBorrowed()){
            System.out.println(this.name + ", this book is borrowed by someone else, you cant borrow it right now!");
        } else if(this.borrowedBookCounter >= 5){
            System.out.println(this.name + ", you borrowed " + this.borrowedBookCounter + " books and you can't borrow more!");
        } else if(!library.getBooks().contains(book)){
            System.out.println(this.name + ", there isn't any book which you wanted in our library!");
        } else{
            Map<Book, Member> myMap = library.getBookBorrowerMap();
            Date date = new Date();
            myMap.put(book, this);
            book.setBorrower(this);
            book.updateBookBorrowStatus();
            book.setDateOfBorrow(date);
            library.setBookBorrowerMap(myMap);
            this.borrowedBookCounter += 1;
            System.out.println(this.name + " borrowed [" + book.getTitle() + "] on [" + book.getDateOfBorrow() + "]");
        }
    }
    @Override
    public void borrowBookByName(String bookName){

    }
    @Override
    public void returnBook(Library library, Book book){
        Map<Book, Member> myMap = library.getBookBorrowerMap();
        int check = 0;
        Iterator<Book> iter = myMap.keySet().iterator();
        while(iter.hasNext()){
            Book myBook = iter.next();
            if(book.equals(myBook) && this.equals(book.getBorrower())){
                iter.remove();
                check++;
                book.updateBookBorrowStatus();
                System.out.println("Ödünç Listesinden kaldırılan kitap: " + book.getTitle());
                break;
            }
        }
        if(check == 0){
            System.out.println("Geri vermek istediğin kitap senin üzerine kayıtlı değil!");
        }
        library.setBookBorrowerMap(myMap);
    }
    @Override
    public String toString(){
        return this.name;
    }
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        Member myMember = (Member) o;
        return this.memberID == myMember.getMemberID();
    }
}
