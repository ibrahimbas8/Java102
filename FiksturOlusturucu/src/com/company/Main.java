package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Random rand = new Random();

        ArrayList<Team> teams = new ArrayList<>();
        ArrayList<Team> temp = new ArrayList<>();
        ArrayList<Week> weeks = new ArrayList<>();

        Team homeTeam;
        Team awayTeam;

        teams.add(new Team("Fenerbahçe"));
        teams.add(new Team("Galatasaray"));
        teams.add(new Team("Beşiktaş"));
        teams.add(new Team("Keçiörengücü"));
        teams.add(new Team("Ankaragücü"));
        teams.add(new Team("Gençlerbirliği"));


        if (teams.size() % 2 ==1 ) {
            teams.add(new Team("BAY"));
        }

        int numberOfGames = teams.size() - 1;
        int week = 1;

        while (numberOfGames > 0) {
            temp.addAll(teams);
            Week wk = new Week(week);

            while (temp.size() > 0) {
                int random = rand.nextInt(temp.size());
                homeTeam = temp.get(random);
                temp.remove(homeTeam);
                random = rand.nextInt(temp.size());
                awayTeam = temp.get(random);
                if (!homeTeam.opponent.contains(awayTeam.name)) {
                    homeTeam.opponent.add(awayTeam.name);
                    temp.remove(awayTeam);
                    wk.homeTeam.add(homeTeam.name);
                    wk.awayTeam.add(awayTeam.name);
                }
                else {
                    wk = new Week(week);
                    temp.clear();
                    temp.addAll(teams);
                }
            }
            numberOfGames--;
            week++;
            weeks.add(wk);
        }

        for (Team team:teams){
            System.out.println("- " + team.name);
        }
        System.out.println("-----------------------------------");
        int counter = 1;
        for(Week w : weeks){
            System.out.println("Round: " + counter);
            for (int i = 0; i < w.awayTeam.size(); i++) {
                System.out.println(w.homeTeam.get(i) + " vs " + w.awayTeam.get(i));
            }
            counter++;
            System.out.println("-----------------------------------");
        }
        for(Week w : weeks){
            System.out.println("Round: " + counter);
            for (int i = 0; i < w.awayTeam.size(); i++) {
                System.out.println(w.awayTeam.get(i) + " vs " + w.homeTeam.get(i));
            }
            counter++;
            System.out.println("-----------------------------------");
        }

    }
}
