package org.game;

/**
 * Это абстрактный класс Волшебник, наследуется от класса Юнит
 */
public abstract class Wizard extends Unit{
    int maxMana;
    int curMana;

    /**
     * Это конструктор для класса волшебник
     * @param attack это очки атаки
     * @param initiative это очки инициативы
     * @param damage это наносимый урон
     * @param maxMana это максимальное количество маны
     * @param curMana это текущее количество маны
     */
    public Wizard(int attack, int initiative, int[] damage, int maxMana, int curMana) {
        super(10, 10, 3, attack, initiative, damage);
        this.maxMana = maxMana;
        this.curMana = curMana;
    }
}
