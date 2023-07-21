package org.game.Units;

/**
 * Это класс Разбойник, наследуется от абстрактного класса Пехота.
 */
public class Thug extends Infantry{
    /**
     * Это конструктор для класса Разбойник. Параметры: максимальное здоровье 20, защита 8, атака 4, инициатива 4
     * @param x это координата по оси х
     * @param y это координата по оси у
     */
    public Thug(int x, int y) {
        super(x, y);
    }

}
