package org.game;

import java.util.ArrayList;

/**
 * Это абстрактный класс Волшебник, наследуется от класса Юнит. Лечит дружественных юнитов. Его наследники (классы Монах
 * и Маг) получают параметры: максимальное здоровье 10, защита 3, атака 8, инициатива 2, максимальное количество маны 100
 */
public abstract class Wizard extends Unit{
    int maxMana, curMana;

    /**
     * Это конструктор для класса волшебник
     * @param x это координата по оси х
     * @param y это координата по оси у
     */
    public Wizard(int x, int y) {
        super(10, 10, 3, 8, 2, new float[]{1, 5}, x, y);
        this.maxMana = this.curMana = 100;
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
