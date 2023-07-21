package org.game.Units;

import java.util.ArrayList;

/**
 * Это абстрактный класс Пехота, наследуется от абстрактного класса Юнит. Атакует в ближнем бою. Его наследники
 * (классы Разбойник и Копейщик) получают параметры: максимальное здоровье 20, защита 10, атака 10, инициатива 3
 */
public abstract class Infantry extends Unit {
    /**
     * Это конструктор для класса Пехота
     *
     * @param x это координата по оси х
     * @param y это координата по оси у
     */
    public Infantry(int x, int y) {
        super(10, 10, 10, 3, new float[]{1, 9}, x, y);
    }

    /**
     * Это метод выполнения хода пехотинца. Если он жив, и ближайший враг находится на соседней клетке, он атакует
     * врага. Если ближайший враг не находится на соседней клетке, он его находит и делает ход на одну клетку в его
     * сторону при условии, что на ней не стоит дружественный юнит. В противном случае остается на месте.
     * @param enemiesList это список юнитов-противников
     * @param friendsList это список юнитов-союзников
     */
    @Override
    public void step(ArrayList<Unit> friendsList, ArrayList<Unit> enemiesList) {
        if (this.curHP == 0) return;
        Unit nearestEnemy = enemiesList.get((int) nearest(enemiesList)[1]);
        if (nearest(enemiesList)[0] == 1) {
            nearestEnemy.getDamage(this.damage);
            state = "attacked";
//            System.out.println("Пехотинец " + this.name + "[" + this.coord.x + ", " + this.coord.y + "] атаковал " +
//                    nearestEnemy.name  + "[" + nearestEnemy.coord.x + ", " + nearestEnemy.coord.y + "]" +
//                    " здоровье у него стало " + nearestEnemy.curHP);
        } else {
            for (Unit unit : friendsList) {
                if (unit.coord.x == coord.newPosition(nearestEnemy.coord).x &&
                        unit.coord.y == coord.newPosition(nearestEnemy.coord).y) {
//                    System.out.println("Пехотинец " + this.name + "[" + this.coord.x + ", " + this.coord.y +
//                            "] никуда не пошел");
                    return;
                }
            }
            this.coord = coord.newPosition(nearestEnemy.coord);
//            System.out.println("Пехотинец " + this.name + " переместился на координаты [" + this.coord.x + ", " +
//                    this.coord.y + "]");
        }
    }
}
