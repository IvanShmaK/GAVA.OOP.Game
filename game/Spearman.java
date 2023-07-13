package org.game;


/**
 * Это класс Копейщик, наследуется от абстрактного класса Пехота.
 */
public class Spearman extends Infantry{
    /**
     * Это конструктор для класса Копейщик.
     * @param x это координата по оси х
     * @param y это координата по оси у
     */
    public Spearman(int x, int y) {
        super(x, y);
    }

    /**
     * Это метод получения информации об экземпляре класса Копейщик
     * @return возвращает класс с именем, текущее здоровье и координаты на поле
     */
    @Override
    public String getInfo() {
        return String.format("Копейщик %s; здоровье: %.1f/%d; координаты: х=%d, у=%d", name, curHP, maxHP, coord.x, coord.y);
    }

    /**
     * Это метод получения имени юнита
     * @return класс и имя юнита
     */
    @Override
    public String getName() {
        return String.format("Копейщик %s", name);
    }

}
