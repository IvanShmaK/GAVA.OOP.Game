package org.example;

/**
 * Это класс Снайпер, наследуется от абстрактного класса Стрелок. Он стреляет во вражеских юнитов, нет штрафа за расстояние.
 */
public class Sniper extends Shooter{
    /**
     * Это конструктор для класса Снайпер
     * @param name это имя снайпера
     */
    public Sniper(String name) {
        super(name, 20, 7, new int[]{1, 5}, 5);
    }
}
