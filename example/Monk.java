package org.example;

/**
 * Это класс Монах, наследуется от абстрактного класса Волшебник. Он лечит дружественных юнитов.
 */
public class Monk extends Wizard{
    /**
     * Это конструктор для класса Монах
     * @param name это имя Монаха
     */
    public Monk(String name) {
        super(name, 5, 2, new int[]{1, 5}, 100);
    }


}
