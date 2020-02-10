package com.company.lesson4.library;

import java.util.Arrays;

public class Library {
    Book[] books = new Book[10];

    public void addBook(Book book){
        for (int i = 0; i <this.books.length ; i++) {
            if (this.books[i] == null){
                this.books[i] = book;
                break;
            }
        }
    }

    public Book getBook(String bookTitle){
        Book result = null;
        for (int i = 0; i <this.books.length ; i++) {
            if (bookTitle.equals(books[i].getTitle())){
                result = books[i];
                break;
            }
        }
        return result;
    }


    @Override
    public String toString() {
        return "Library{" +
                "books=" + Arrays.toString(books) +
                '}';
    }
}
