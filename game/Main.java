package org.game;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayList<Unit> team1 = createTeam1();
        ArrayList<Unit> team2 = createTeam2();

        System.out.println("Первая команда:");
        team1.forEach(n -> System.out.println(n.getInfo()));
        System.out.println("\nВторая команда:");
        team2.forEach(n -> System.out.println(n.getInfo()));
        System.out.println();
        team1.forEach(n -> n.step(team2));


    }

    /**
     * Это метод, который формирует первую команду из 10 рандомно выбранных юнитов. Она находится с левой стороны игрового поля.
     * @return возвращает сформированный список юнитов
     */
    public static ArrayList<Unit> createTeam1 () {
        int x = 0;
        ArrayList<Unit> team = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int val = new Random().nextInt(4);
            switch (val) {
                case 0 -> team.add(new Monk(x, i));
                case 1 -> team.add(new Thug(x, i));
                case 2 -> team.add(new Sniper(x, i));
                case 3 -> team.add(new Peasant(x, i));
            }
        }
        return team;
    }

    /**
     * Это метод, который формирует вторую команду из 10 рандомно выбранных юнитов. Она находится с правой стороны игрового поля.
     * @return возвращает сформированный список юнитов
     */
    public static ArrayList<Unit> createTeam2 () {
        int x = 10;
        ArrayList<Unit> team = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int val = new Random().nextInt(4);
            switch (val) {
                case 0 -> team.add(new Magician(x, i));
                case 1 -> team.add(new Spearman(x, i));
                case 2 -> team.add(new Crossbowman(x, i));
                case 3 -> team.add(new Peasant(x, i));
            }
        }
        return team;
    }

}