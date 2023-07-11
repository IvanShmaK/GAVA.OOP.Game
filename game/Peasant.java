package org.game;

import java.util.ArrayList;

/**
 * Это класс Крестьянин, наследуется от абстрактного класса Юнит. Он подносит стрелы для стрелков. Может атаковать
 * вражеского юнита, если тот окажется рядом.
 */
public class Peasant extends Unit{
    /**
     * Это конструктор для класса Крестьянин. Параметры: максимальное здоровье 1, защита 1, атака 1, инициатива 1
     * @param x это координата по оси х
     * @param y это координата по оси у
     */
    public Peasant(int x, int y) {
        super(1, 1, 1, 1, 1, new int[]{1}, x, y);
    }

    /**
     * Это метод выполнения хода
     * @param list это список юнитов-противников
     */
    @Override
    public void step(ArrayList<Unit> list) {
        System.out.printf("Ближайший к Крестьянину %s противник - %s, расстояние до него - %.1f%n", name,
                list.get((int)nearest(list)[1]).getName(), nearest(list)[0]);
    }

    /**
     * Это метод получения информации об экземпляре класса Крестьянин
     * @return возвращает класс с именем, текущее здоровье и координаты на поле
     */
    @Override
    public String getInfo() {
        return String.format("Крестьянин %s; здоровье: %.1f/%d; координаты: х=%d, у=%d", name, curHP, maxHP, coord.x,
                coord.y);
    }

    /**
     * Это метод получения имени юнита
     * @return класс и имя юнита
     */
    @Override
    public String getName() {
        return String.format("Крестьянин %s", name);
    }



    public void bringArrow () {} //метод доставки стрелы одному из стрелков один раз за ход

}
