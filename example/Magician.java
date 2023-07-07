package org.example;

/**
 * Это класс Маг, наследуется от абстрактного класса Волшебник. Он может атаковать вражеских юнитов магией, либо лечить дружественных
 */
public class Magician extends Wizard{
    /**
     * Это конструктор для класса Маг
     * @param name это имя Мага
     */
    public Magician(String name) {
        super(name, 8, 3, new int[]{1, 5}, 150);
    }

    public void castMagic () {} //метод атаки вражеских юнитов магией
}
