package org.game.Units;

import java.util.ArrayList;

/**
 * Это абстрактный класс Стрелок, наследуется от абстрактного класса Юнит. Он атакует врагов на расстоянии. Если к нему
 * подошли вплотную, может атаковать в ближнем бою. Его наследники (классы Снайпер и Арбалетчик) получают параметры:
 * максимальное здоровье 15, защита 5, атака 9, инициатива 4, максимальное количество стрел 5
 */
public abstract class Shooter extends Unit{
    protected int maxArrows, curArrows;

    /**
     * Это конструктор для класса Стрелок
     * @param x это координата по оси х
     * @param y это координата по оси у
     */
    public Shooter(int x, int y) {
        super(10, 10, 5, 9, 4, new float[]{1, 5}, x, y);
        this.maxArrows = this.curArrows = 5;
    }

    /**
     * Это метод выполнения хода для стрелка. Если стрелок жив (curHP > 0) и у него есть стрелы (curArrows > 0), то
     * он находит ближайшего противника и стреляет в него. Если в дружественном отряде есть живой крестьянин, который
     * не занят (state == free), крестьянин приносит стрелку стрелу (количество стрел не уменьшается). Иначе количество
     * стрел уменьшается на одну.
     * @param enemiesList это список юнитов-противников
     * @param friendsList это список юнитов-союзников
     */
    @Override
    public void step(ArrayList<Unit> friendsList, ArrayList<Unit> enemiesList) {
//        System.out.printf("Ближайший к %s противник - %s, расстояние до него - %.1f%n", this.getName(),
//                enemiesList.get((int)nearest(enemiesList)[1]).getName(), nearest(enemiesList)[0]);
        System.out.println(this.getInfo());
        if (this.curHP == 0 || this.curArrows == 0) return;
        Unit nearestEnemy = enemiesList.get((int)nearest(enemiesList)[1]);
        System.out.println("    " + this.getName() + " атакует " + nearestEnemy.getName());
        nearestEnemy.getDamage(this.damage);
        this.state = "shot";
        for (Unit unit : friendsList) {
            if (unit.getClass().equals(Peasant.class) &&
                    unit.curHP > 0 &&
                    unit.state.equals("stand")) {
                unit.state = "busy";
                System.out.println("    " + this.getName() + " получил стрелу от " + unit.getName() + " и тот стал занят");
                return;
            }
        }
        this.curArrows--;
        System.out.println("    " + this.getName() + " не получил стрелу, у него их стало " + this.curArrows);
    }

}
