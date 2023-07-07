package org.example;

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
     * Это конструктор класса юнит
     * @param name это имя юнита
     * @param maxHP это максимальное здоровье юнита
     * @param curHP это текущее здоровье юнита
     * @param armor это очки защиты юнита
     * @param attack это очки атаки юнита
     * @param initiative это очки инициативы юнита
     * @param damage это уровень наносимого урона
     */
    public Unit(String name, int maxHP, float curHP, int armor, int attack, int initiative, int[] damage) {
        this.name = name;
        this.maxHP = maxHP;
        this.curHP = curHP;
        this.armor = armor;
        this.attack = attack;
        this.initiative = initiative;
        this.damage = damage;
    }

    public String getInfo() {} //метод получения информации о юните

    public void attack() {} //метод атаки другого юнита

    public void getDamage() {} //метод получения урона

    public void step() {} //метод движения юнитов по игровому полю
}

