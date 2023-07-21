package org.game.Units;

/**
 * Это класс Снайпер, наследуется от абстрактного класса Стрелок.
 */
public class Archer extends Shooter{
    /**
     * Это конструктор для класса Снайпер.
     * @param x это координата по оси х
     * @param y это координата по оси у
     */
    public Archer(int x, int y) {
        super(x, y);
    }

}
