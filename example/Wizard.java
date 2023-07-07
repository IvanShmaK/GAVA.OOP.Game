package org.example;

/**
 * Это абстрактный класс Волшебник, наследуется от класса Юнит
 */
public abstract class Wizard extends Unit{
    int mana;

    /**
     * Это конструктор для класса волшебник
     * @param name это имя
     * @param attack это очки атаки
     * @param initiative это очки инициативы
     * @param damage это наносимый урон
     * @param mana это количество маны
     */
    public Wizard(String name, int attack, int initiative, int[] damage, int mana) {
        super(name, 10, 10, 3, attack, initiative, damage);
        this.mana = mana;
    }

    public void heal() {} //метод лечения дружественных юнитов
}
