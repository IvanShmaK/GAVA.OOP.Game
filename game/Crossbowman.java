package org.game;

import java.util.ArrayList;

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
        return String.format("Арбалетчик %s; здоровье: %.1f/%d; стрелы: %d/%d; координаты: х=%d, у=%d", name, curHP, maxHP, maxArrows, curArrows, coord.x, coord.y);
    }

    /**
     * Это метод получения имени юнита
     * @return класс и имя юнита
     */
    @Override
    public String getName() {
        return String.format("Арбалетчик %s", name);
    }

    /**
     * Это метод выполнения хода
     * @param list это список юнитов-противников
     */
    @Override
    public void step(ArrayList<Unit> list) {
        System.out.printf("Ближайший к Арбалетчику %s противник - %s, расстояние до него - %.1f%n", name,
                list.get((int)nearest(list)[1]).getName(), nearest(list)[0]);
    }
}
