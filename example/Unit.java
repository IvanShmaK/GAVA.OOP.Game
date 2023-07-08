package org.example;

import java.util.Random;

/**
 * Это класс-прототип всех юнитов
 */
public abstract class Unit {
    String name;
    int maxHP;
    float curHP;
    int armor, attack, initiative;
    int[] damage;

    /**
     * Это конструктор класса Юнит. Имя ему выбирается рандомно из списка имен (файл Name.java)
     * @param maxHP это максимальное здоровье юнита
     * @param curHP это текущее здоровье юнита
     * @param armor это очки защиты юнита
     * @param attack это очки атаки юнита
     * @param initiative это очки инициативы юнита
     * @param damage это уровень наносимого урона
     */
    public Unit(int maxHP, float curHP, int armor, int attack, int initiative, int[] damage) {
        this.name = String.valueOf(Name.values()[new Random().nextInt(Name.values().length)]);
        this.maxHP = maxHP;
        this.curHP = curHP;
        this.armor = armor;
        this.attack = attack;
        this.initiative = initiative;
        this.damage = damage;
    }

    /**
     * Это метод получения информации о юните
     * @return возвращает имя юнита
     */
    public String getInfo() {
        return name;
    }

    public void attack() {} //метод атаки другого юнита

    public void getDamage() {} //метод получения урона

    public void step() {} //метод осуществления хода юнита
}

