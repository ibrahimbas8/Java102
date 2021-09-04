package com.company;

import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        //TreeSet<Book> books = new TreeSet<>(new OrderBookPageNumberComparator().reversed());
        TreeSet<Book> books = new TreeSet<>(new OrderBookNameComparator());
        
        books.add(new Book("LOTR" , 1000, "JRR Tolkien","02-08-1955"));
        books.add(new Book("Serenad" , 200, "Zülfü Livaneli","25-03-2005"));
        books.add(new Book("Ceviz Kabuğunda Evren" , 500, "Stefen Hawking","12-06-2015"));
        books.add(new Book("Kürk Mantolu Madonna" , 300, "Sabahattin Ali","22-12-1968"));
        books.add(new Book("Yüzyıllık Yalnızlık" , 400, "Gabriel Garcia Marquez","11-7-1976"));

        for (Book book: books){
            System.out.println(book.getBookName());
        }
    }
}
