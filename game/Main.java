package org.game;

import org.game.Units.*;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static ArrayList<Unit> team1 = createTeam(0);
    public static ArrayList<Unit> team2 = createTeam(10);
    public  static ArrayList<Unit> allTeam = new ArrayList<>();
    public static void main(String[] args) {

        System.out.println("Первая команда:");
        team1.forEach(n -> System.out.println(n.getInfo()));
        System.out.println("\nВторая команда:");
        team2.forEach(n -> System.out.println(n.getInfo()));
        System.out.println();

        allTeam.addAll(team1);
        allTeam.addAll(team2);
        allTeam.sort((o1, o2) -> o2.initiative - o1.initiative);

        System.out.println("Первый ход:");
        for (Unit unit: allTeam) {
            if (team1.contains(unit)) unit.step(team1, team2);
            else unit.step(team2, team1);
        }
        System.out.println("\nВторой ход:");
        for (Unit unit: allTeam) {
            if (team1.contains(unit)) unit.step(team1, team2);
            else unit.step(team2, team1);
        }

    }

    /**
     * Это метод по созданию команды. Он принимает на вход координату y (начальную, либо конечную координату игрового
     * поля по оси y). Исходя из этого команда формируется на одной из сторон игрового поля. По умолчанию команда из 10
     * юнитов.
     * @param y координата по оси y на игровом поле
     * @return список юнитов, находящихся в одной команде, отсортированных по инициативе
     */
    public static ArrayList<Unit> createTeam (int y) {
        ArrayList<Unit> team = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int val = new Random().nextInt(4);
            switch (val) {
                case 0 -> {
                    if (y == 0) team.add(new Friar(i, y));
                    else team.add(new Magician(i, y));
                }
                case 1 -> {
                    if (y == 0) team.add(new Thug(i, y));
                    else team.add(new Spearman(i, y));
                }
                case 2 -> {
                    if (y == 0) team.add(new Archer(i, y));
                    else team.add(new Crossbowman(i, y));
                }
                default -> team.add(new Peasant(i, y));
            }
        }
        //team.sort((o1, o2) -> o2.initiative - o1.initiative);
        return team;
    }

}