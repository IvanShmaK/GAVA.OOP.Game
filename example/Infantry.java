package org.example;

/**
 * Это абстрактный класс Пехота, наследуется от абстрактного класса Юнит
 */
public abstract class Infantry extends Unit{
    /**
     * Это конструктор для класса Пехота
     * @param armor это очки защиты юнита
     * @param attack это очки атаки юнита
     * @param initiative это очки инициативы юнита
     * @param damage это наносимый урон
     */
    public Infantry(int armor, int attack, int initiative, int[] damage) {
        super(20, 20, armor, attack, initiative, damage);
    }
}
