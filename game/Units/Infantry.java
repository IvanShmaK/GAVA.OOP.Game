package org.game.Units;

import java.util.ArrayList;

/**
 * Это абстрактный класс Пехота, наследуется от абстрактного класса Юнит. Атакует в ближнем бою. Его наследники
 * (классы Разбойник и Копейщик) получают параметры: максимальное здоровье 20, защита 10, атака 10, инициатива 3
 */
public abstract class Infantry extends Unit{
    /**
     * Это конструктор для класса Пехота
     * @param x это координата по оси х
     * @param y это координата по оси у
     */
    public Infantry(int x, int y) {
        super(20, 20, 10, 10, 3, new float[]{1, 5}, x, y);
    }

    /**
     * Это метод выполнения хода
     * @param enemiesList это список юнитов-противников
     * @param friendsList это список юнитов-союзников
     */
    @Override
    public void step(ArrayList<Unit> friendsList, ArrayList<Unit> enemiesList) {
//        System.out.printf("Ближайший к %s противник - %s, расстояние до него - %.1f%n", this.getName(),
//                enemiesList.get((int)nearest(enemiesList)[1]).getName(), nearest(enemiesList)[0]);
        System.out.println(this.getInfo());
    }
}
