package org.example;

/**
 * Это класс Арбалетчик, наследуется от абстрактного класса Стрелок. Он стреляет во вражеских юнитов, имеет штраф за расстояние.
 */
public class Crossbowman extends Shooter{
    /**
     * Это конструктор для класса Арбалетчик. Параметры: максимальное здоровье 10, защита 5, атака 8, инициатива 6, максимальное количество стрел 10
     */
    public Crossbowman() {
        super(8, 6, new int[]{1, 5}, 10, 10);
    }

    /**
     * Это метод получения информации об экземпляре класса Арбалетчик
     * @return возвращает класс с именем, текущее здоровье и текущее количество стрел
     */
    @Override
    public String getInfo() {
        return String.format("Арбалетчик %s, здоровье: %.1f/%d, стрелы: %d/%d", name, curHP, maxHP, maxArrows, curArrows);
    }
}
