package org.game.Units;

import java.util.ArrayList;

/**
 * Это класс Крестьянин, наследуется от абстрактного класса Юнит. Он подносит стрелы для стрелков (за один ход один
 * крестьянин приносит одну стрелу одному стрелку, после чего его статус меняется со "свободен" на "занят").
 */
public class Peasant extends Unit{
    /**
     * Это конструктор для класса Крестьянин. Параметры: максимальное здоровье 1, защита 1, атака 1, инициатива 1
     * @param x это координата по оси х
     * @param y это координата по оси у
     */
    public Peasant(int x, int y) {
        super(10, 10, 1, 1, new float[]{1}, x, y);
    }

    /**
     * Это метод выполнения хода крестьянина. Если он жив (curHP > 0), его состояние меняется на свободен.
     * @param enemiesList это список юнитов-противников
     * @param friendsList это список юнитов-союзников
     */
    @Override
    public void step(ArrayList<Unit> friendsList, ArrayList<Unit> enemiesList) {
        if (this.curHP > 0) {
            this.state = "stand";
            //System.out.println("Крестьянин " + this.name + " снова активен");
        }

    }
}
