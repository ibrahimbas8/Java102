package com.company;

import java.util.ArrayList;
import java.util.List;

public class ThreadRace extends Thread{
    private final Object LOCK = new Object();
    List<Integer> list;
    List<Integer> odd =  new ArrayList<>();; //tek sayılar
    List<Integer> even =  new ArrayList<>();; //çift sayılar
    private int id= 1;

    public ThreadRace(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        int firstIndex;
        int lastIndex;
        synchronized (LOCK) {
            firstIndex = (this.id - 1) * 2500;
            lastIndex = (this.id) * 2500;
            System.out.println(Thread.currentThread().getName() + " Başlangıç : " + firstIndex + " Bitiş : " +lastIndex);
            this.id++;
        }
        List<Integer> sublist;
        sublist = this.list.subList(firstIndex, lastIndex);
        System.out.println(Thread.currentThread().getName() + " Parça: " + sublist);

        for (Integer i : this.list) {
            if (i % 2 == 0) {
                synchronized (LOCK) {
                    this.even.add(i);
                }
            }
            else {
                synchronized (LOCK) {
                    this.odd.add(i);
                }
            }
        }
    }
    public void printEven(){
        for (Integer i: even){

        }
    }
    public void printOdd(){
        for (Integer i: odd){

        }
    }
}
