package org.example;

/**
 * Это класс Разбойник, наследуется от абстрактного класса Пехота. Он подходит к вражеским юнитам и атакует их, игнорируя защиту
 */
public class Thug extends Infantry{
    /**
     * Это конструктор для класса Разбойник
     * @param name это имя Разбойника
     */
    public Thug(String name) {
        super(name, 8, 4, 4, new int[]{1, 5});
    }
}
