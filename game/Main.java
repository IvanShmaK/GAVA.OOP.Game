package org.game;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayList<Unit> team1 = createTeam(0);
        ArrayList<Unit> team2 = createTeam(10);

//        System.out.println("Первая команда:");
//        team1.forEach(n -> System.out.println(n.getInfo()));
//        System.out.println("\nВторая команда:");
//        team2.forEach(n -> System.out.println(n.getInfo()));
//        System.out.println();
        System.out.println("Ход первой команды:");
        team1.forEach(n -> n.step(team1, team2));

        System.out.println("\nХод второй команды:");
        team2.forEach(n -> n.step(team2, team1));

        System.out.println("\nХод первой команды:");
        team1.forEach(n -> n.step(team1, team2));

        System.out.println("\nХод второй команды:");
        team2.forEach(n -> n.step(team2, team1));

        System.out.println("\nХод первой команды:");
        team1.forEach(n -> n.step(team1, team2));

        System.out.println("\nХод второй команды:");
        team2.forEach(n -> n.step(team2, team1));


    }

    /**
     * Это метод по созданию команды. Он принимает на вход координату х (начальную, либо конечную координату игрового
     * поля). Исходя из этого команда формируется на одной из сторон игрового поля. По умолчанию команда из 10 юнитов.
     * Команда сортируется по убыванию инициативы.
     * @param x координата по оси х на игровом поле
     * @return список юнитов, находящихся в одной команде, отсортированных по инициативе
     */
    public static ArrayList<Unit> createTeam (int x) {
        ArrayList<Unit> team = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int val = new Random().nextInt(4);
            switch (val) {
                case 0 -> {
                    if (x == 0) team.add(new Monk(x, i));
                    else team.add(new Magician(x, i));
                }
                case 1 -> {
                    if (x == 0) team.add(new Thug(x, i));
                    else team.add(new Spearman(x, i));
                }
                case 2 -> {
                    if (x == 0) team.add(new Sniper(x, i));
                    else team.add(new Crossbowman(x, i));
                }
                default -> team.add(new Peasant(x, i));
            }
        }
        team.sort(new Comparator<Unit>() {
            @Override
            public int compare(Unit o1, Unit o2) {
                return o2.initiative - o1.initiative;
            }
        });
        return team;
    }

//    /**
//     * Это метод, который удаляет из списка юнита, если его текущее здоровье равно 0 (умершего юнита)
//     * @param list команда юнитов
//     */
//    public static void deleteDeadUnit (ArrayList<Unit> list) {
//        list.removeIf(unit -> unit.curHP == 0);
//    }


}