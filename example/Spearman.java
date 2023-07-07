package org.example;

/**
 * Это класс Копейщик, наследуется от абстрактного класса Пехота. Он подходит к вражеским юнитам и атакует их в ближнем бою.
 */
public class Spearman extends Infantry{
    /**
     * Это конструктор для класса Копейщик
     * @param name это имя Копейщика
     */
    public Spearman(String name) {
        super(name, 10, 5, 5, new int[]{1, 5});
    }
}
