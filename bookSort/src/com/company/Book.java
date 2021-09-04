package com.company;

public class Book {
    private String bookName;
    private int bookPageNumber;
    private String authorName;
    private String date;

    public Book(String bookName, int bookPageNumber, String authorName, String date) {
        this.bookName = bookName;
        this.bookPageNumber = bookPageNumber;
        this.authorName = authorName;
        this.date = date;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookPageNumber() {
        return bookPageNumber;
    }

    public void setBookPageNumber(int bookPageNumber) {
        this.bookPageNumber = bookPageNumber;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
