package org.game.Units;

/**
 * Это класс Арбалетчик, наследуется от абстрактного класса Стрелок.
 */
public class Crossbowman extends Shooter{
    /**
     * Это конструктор для класса Арбалетчик.
     * @param x это координата по оси х
     * @param y это координата по оси у
     */
    public Crossbowman(int x, int y) {
        super(x, y);
    }

    /**
     * Это метод получения информации об экземпляре класса Арбалетчик
     * @return возвращает класс с именем, текущее здоровье, текущее количество стрел и координаты на поле
     */
    @Override
    public String getInfo() {
        return String.format("Арбалетчик %s; здоровье: %.1f/%d; стрелы: %d/%d; координаты: х=%d, у=%d; состояние: %s",
                name, curHP, maxHP, curArrows, maxArrows, coord.x, coord.y, state);
    }

    /**
     * Это метод получения имени юнита
     * @return класс и имя юнита
     */
    @Override
    public String getName() {
        return String.format("Арбалетчик %s", name);
    }


}
