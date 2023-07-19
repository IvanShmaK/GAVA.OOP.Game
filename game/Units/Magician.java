package org.game.Units;

/**
 * Это класс Маг, наследуется от абстрактного класса Волшебник.
 */
public class Magician extends Wizard{
    /**
     * Это конструктор для класса Маг.
     * @param x это координата по оси х
     * @param y это координата по оси у
     */
    public Magician(int x, int y) { super(x, y); }

    /**
     * Это метод получения информации об экземпляре класса Маг
     * @return возвращает класс с именем, текущее здоровье, текущее количество маны и координаты на поле
     */
    @Override
    public String getInfo() {
        return String.format("Маг %s; здоровье: %.1f/%d; мана: %d/%d; координаты: х=%d, у=%d", name, curHP, maxHP, curMana, maxMana, coord.x, coord.y);
    }

    /**
     * Это метод получения имени юнита
     * @return класс и имя юнита
     */
    @Override
    public String getName() {
        return String.format("Маг %s", name);
    }


}
