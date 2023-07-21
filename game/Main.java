package org.game;

import org.game.Units.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static ArrayList<Unit> team1 = createTeam(1);
    public static ArrayList<Unit> team2 = createTeam(10);
    public  static ArrayList<Unit> allTeam = new ArrayList<>();
    public static void main(String[] args) {
        allTeam.addAll(team1);
        allTeam.addAll(team2);
        allTeam.sort((o1, o2) -> o2.initiative - o1.initiative);

        Scanner in = new Scanner(System.in);
        while (true) {
            View.view();
            in.nextLine();
            for (Unit unit: allTeam) {
                if (team1.contains(unit)) unit.step(team1, team2);
                else unit.step(team2, team1);
            }
            if (isTeamDead(team1)) {
                System.out.println("Team2 (blue) win!");
                break;
            }
            if (isTeamDead(team2)) {
                System.out.println("Team1 (green) win!");
                break;
            }
        }

    }

    /**
     * Это метод по созданию команды. Он принимает на вход координату y (начальную, либо конечную координату игрового
     * поля по оси y). Исходя из этого команда формируется на одной из сторон игрового поля. По умолчанию команда из 10
     * юнитов.
     * @param x координата по оси x на игровом поле
     * @return список юнитов, находящихся в одной команде, отсортированных по инициативе
     */
    public static ArrayList<Unit> createTeam (int x) {
        ArrayList<Unit> team = new ArrayList<>();
        for (int i = 1; i < 11; i++) {
            int val = new Random().nextInt(4);
            switch (val) {
                case 0 -> {
                    if (x == 1) team.add(new Friar(x, i));
                    else team.add(new Magician(x, i));
                }
                case 1 -> {
                    if (x == 1) team.add(new Thug(x, i));
                    else team.add(new Spearman(x, i));
                }
                case 2 -> {
                    if (x == 1) team.add(new Archer(x, i));
                    else team.add(new Crossbowman(x, i));
                }
                default -> team.add(new Peasant(x, i));
            }
        }
        team.sort((o1, o2) -> o2.initiative - o1.initiative);
        return team;
    }

    /**
     * Это метод, которы определяет, есть ли живые юниты в команде.
     * @param team это список юнитов
     * @return true, если все юниты в команде мертвы, либо false, если есть хотя бы один живой
     */
    static boolean isTeamDead (ArrayList<Unit> team) {
        for (Unit unit: team) {
            if (!unit.isDead()) return false;
        }
        return true;
    }

}