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
        super(1, 1, 1, 1, 1, new float[]{1}, x, y);
    }

    /**
     * Это метод выполнения хода крестьянина. Если он жив (curHP > 0), его состояние меняется на свободен.
     * @param enemiesList это список юнитов-противников
     * @param friendsList это список юнитов-союзников
     */
    @Override
    public void step(ArrayList<Unit> friendsList, ArrayList<Unit> enemiesList) {
//        System.out.printf("Ближайший к Крестьянину %s противник - %s, расстояние до него - %.1f%n", name,
//                enemiesList.get((int)nearest(enemiesList)[1]).getName(), nearest(enemiesList)[0]);
        System.out.println(this.getInfo());
        if (this.curHP > 0) this.state = "stand";
    }

    /**
     * Это метод получения информации об экземпляре класса Крестьянин
     * @return возвращает класс с именем, текущее здоровье и координаты на поле
     */
    @Override
    public String getInfo() {
        return String.format("Крестьянин %s; здоровье: %.1f/%d; координаты: х=%d, у=%d; состояние: %s", name, curHP,
                maxHP, coord.x, coord.y, state);
    }

    /**
     * Это метод получения имени юнита
     * @return класс и имя юнита
     */
    @Override
    public String getName() {
        return String.format("Крестьянин %s", name);
    }

}
