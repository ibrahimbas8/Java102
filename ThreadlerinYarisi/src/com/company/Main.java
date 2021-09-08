package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i <= 10000; i++) {
            list.add(i);
        }
        ThreadRace threadRace = new ThreadRace(list);
        Thread t1 = new Thread(threadRace);
        Thread t2 = new Thread(threadRace);
        Thread t3 = new Thread(threadRace);
        Thread t4 = new Thread(threadRace);

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}
