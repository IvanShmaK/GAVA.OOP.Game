package org.game;

import java.util.ArrayList;
import java.util.Random;

/**
 * Это класс-прототип всех юнитов
 */
public abstract class Unit implements Interface {
    String name;
    int maxHP;
    float curHP;
    int armor, attack, initiative;
    int[] damage;
    Coordinates coord;

    /**
     * Это конструктор класса Юнит. Имя ему выбирается рандомно из списка имен (файл Name.java)
     * @param maxHP это максимальное здоровье юнита
     * @param curHP это текущее здоровье юнита
     * @param armor это очки защиты юнита
     * @param attack это очки атаки юнита
     * @param initiative это очки инициативы юнита
     * @param damage это уровень наносимого урона
     * @param x это координата по оси х
     * @param y это координата по оси у
     */
    public Unit(int maxHP, float curHP, int armor, int attack, int initiative, int[] damage, int x, int y) {
        this.name = String.valueOf(Name.values()[new Random().nextInt(Name.values().length)]);
        this.maxHP = maxHP;
        this.curHP = curHP;
        this.armor = armor;
        this.attack = attack;
        this.initiative = initiative;
        this.damage = damage;
        coord = new Coordinates(x, y);
    }

    /**
     * Это метод по нахождению ближайшего вражеского юнита для того юнита, у которого данный метод вызывается
     * @param units это список вражеских юнитов
     * @return массив, первым элементом которого будет расстояние до ближайшего вражеского юнита, а вторым - его индекс
     * в передаваемом списке
     */
    public double[] nearest (ArrayList<Unit> units) {
        double[] tempArr = new double[2];
        tempArr[0] = Double.MAX_VALUE;
        for (int i = 0; i < units.size(); i++) {
            if (coord.findDistance(units.get(i).coord) < tempArr[0]){
                tempArr[0] = coord.findDistance(units.get(i).coord);
                tempArr[1] = i;
            }
        }
        return tempArr;
    }

}

