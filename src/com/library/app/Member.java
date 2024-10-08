package com.library.app;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Member extends Library implements IMember{
    private long memberID;
    private String name;
    private Map<String, Date> borrowedBooks;

    public Member(long memberID, String name) {
        this.memberID = memberID;
        this.name = name;
        this.borrowedBooks = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public void borrowBookByBook(Library library, Book book){
        if(library.getBookBorrowerMap().containsKey(book)){
            System.out.println(this.name + ", this book is borrowed by someone else, you cant borrow it right now!");
        } else{
            Map<Book, Member> myMap = library.getBookBorrowerMap();
            myMap.put(book, this);
            library.setBookBorrowerMap(myMap);
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
            if(book.equals(myBook)){
                iter.remove();
                check++;
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
        return "Üye Numarası: " + this.memberID + "\nÜye Adı: " + this.name;
    }
}
