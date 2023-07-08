package org.example;

/**
 * Это класс Крестьянин, наследуется от абстрактного класса Юнит. Он подносит стрелы для стрелков. Может атаковать вражеского юнита, если тот окажется рядом.
 */
public class Peasant extends Unit{
    /**
     * Это конструктор для класса Крестьянин. Параметры: максимальное здоровье 1, защита 1, атака 1, инициатива 1
     */
    public Peasant() {
        super(1, 1, 1, 1, 1, new int[]{1});
    }

    /**
     * Это метод получения информации об экземпляре класса Крестьянин
     * @return возвращает класс с именем и текущее здоровье
     */
    @Override
    public String getInfo() {
        return String.format("Крестьянин %s, здоровье: %.1f/%d", name, curHP, maxHP);
    }

    public void bringArrow () {} //метод доставки стрелы одному из стрелков один раз за ход
}
