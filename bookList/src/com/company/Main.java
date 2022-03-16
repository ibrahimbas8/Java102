package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        ArrayList<Book> bookList = new ArrayList<>();
        HashMap<String,String> bookMapList = new HashMap<>();
        ArrayList<Book> bookPageNumber = new ArrayList<>();

        bookList.add(new Book("Fareler ve insanlar", 200,"John Steinbeck", "1955"));
        bookList.add(new Book("LOTR", 1000,"Jrr tolkien", "1935"));
        bookList.add(new Book("Suç ve Ceza", 500,"Dostoyevski", "1898"));
        bookList.add(new Book("Satranç", 80,"Stefen zweig", "1925"));
        bookList.add(new Book("Dinin kökeni", 650,"Freud", "1918"));
        bookList.add(new Book("Şu hortumlu dünyada fil yanlız bir hayvandır", 250,"Ahmet izgören", "2008"));
        bookList.add(new Book("İlyada", 800,"Homeros ", "-750"));
        bookList.add(new Book("İnce Memed", 400,"Yaşar Kemal", "1955"));
        bookList.add(new Book("Serenad", 450,"Zülfü livaneli", "2011"));
        bookList.add(new Book("Yaban", 250,"Yakup Kadri", "1932"));

        bookList.forEach(book -> {
            bookMapList.put(book.getBookName(), book.getAuthorName());
        });

        //bookMapList.forEach((k,V) -> System.out.println(k + " - " + V));//lambda
        bookMapList.entrySet().stream().forEach(i -> System.out.println( i.getKey() + " : " + i.getValue())); //stream api
        System.out.println("------------------");

        //filtreleme ile 100 den fazla sayfaya sahip kitapları alıyoruz yeni listeye atıyoruz
        bookList.stream().filter( i -> i.getPageNumber()>100).forEach(book -> bookPageNumber.add(book));

        bookPageNumber.stream().forEach(i -> System.out.println(i.getBookName() + " : " + i.getAuthorName() + " : " + i.getPageNumber()));
        System.out.println("------------------");

        bookPageNumber.stream().sorted(Comparator.comparing(Book::getAuthorName)).forEach(i -> System.out.println(i.getBookName() + " : " + i.getAuthorName() + " : " + i.getPageNumber()));
    }
}
