package org.example;

/**
 * Это класс Арбалетчик, наследуется от абстрактного класса Стрелок. Он стреляет во вражеских юнитов, имеет штраф за расстояние.
 */
public class Crossbowman extends Shooter{
    /**
     * Это конструктор для класса Арбалетчик
     * @param name это имя Арбалетчика
     */
    public Crossbowman(String name) {
        super(name, 8, 6, new int[]{1, 5}, 10);
    }
}
