package org.example;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayList<Unit> team1 = createTeam();
        ArrayList<Unit> team2 = createTeam();

        team1.forEach(n -> System.out.println(n.getInfo()));
        System.out.println();
        team2.forEach(n -> System.out.println(n.getInfo()));
    }

    /**
     * Это метод, который формирует команду из 10 рандомно выбранных юнитов
     * @return возвращает сформированный список юнитов
     */
    public static ArrayList<Unit> createTeam () {
        ArrayList<Unit> team = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int val = new Random().nextInt(7);
            switch (val) {
                case 0 -> team.add(new Monk());
                case 1 -> team.add(new Magician());
                case 2 -> team.add(new Thug());
                case 3 -> team.add(new Spearman());
                case 4 -> team.add(new Sniper());
                case 5 -> team.add(new Crossbowman());
                case 6 -> team.add(new Peasant());
            }
        }
        return team;
    }
}