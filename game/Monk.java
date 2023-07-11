package org.game;

import java.util.ArrayList;

/**
 * Это класс Монах, наследуется от абстрактного класса Волшебник.
 */
public class Monk extends Wizard{
    /**
     * Это конструктор для класса Монах. Параметры:
     * @param x это координата по оси х
     * @param y это координата по оси у
     */
    public Monk(int x, int y) {
        super(x, y);
    }

    /**
     * Это метод получения информации об экземпляре класса Монах
     * @return возвращает класс с именем, текущее здоровье, текущее количество маны и координаты на поле
     */
    @Override
    public String getInfo() {
        return String.format("Монах %s; здоровье: %.1f/%d; мана: %d/%d; координаты: х=%d, у=%d", name, curHP, maxHP, curMana, maxMana, coord.x, coord.y);
    }

    /**
     * Это метод получения имени юнита
     * @return класс и имя юнита
     */
    @Override
    public String getName() {
        return String.format("Монах %s", name);
    }

    /**
     * Это метод выполнения хода
     * @param list это список юнитов-противников
     */
    @Override
    public void step(ArrayList<Unit> list) {
        System.out.printf("Ближайший к Монаху %s противник - %s, расстояние до него - %.1f%n", name,
                list.get((int)nearest(list)[1]).getName(), nearest(list)[0]);
    }
}
