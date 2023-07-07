package org.example;

/**
 * Это абстрактный класс Пехота, наследуется от абстрактного класса Юнит
 */
public abstract class Infantry extends Unit{
    /**
     * Это конструктор для класса Пехота
     * @param name это имя юнита
     * @param armor это очки защиты юнита
     * @param attack это очки атаки юнита
     * @param initiative это очки инициативы юнита
     * @param damage это наносимый урон
     */
    public Infantry(String name, int armor, int attack, int initiative, int[] damage) {
        super(name, 20, 20, armor, attack, initiative, damage);
    }
}
