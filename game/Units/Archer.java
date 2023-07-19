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

    /**
     * Это метод получения информации об экземпляре класса Снайпер
     * @return возвращает класс с именем, текущее здоровье, текущее количество стрел и координаты на поле
     */
    @Override
    public String getInfo() {
        return String.format("Снайпер %s; здоровье: %.1f/%d; стрелы: %d/%d; координаты: х=%d, у=%d; состояние: %s",
                name, curHP, maxHP, curArrows, maxArrows, coord.x, coord.y, state);
    }

    /**
     * Это метод получения имени юнита
     * @return класс и имя юнита
     */
    @Override
    public String getName() {
        return String.format("Снайпер %s", name);
    }

}
