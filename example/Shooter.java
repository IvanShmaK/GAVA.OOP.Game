package org.example;

/**
 * Это абстрактный класс Стрелок, наследуется от абстрактного класса Юнит
 */
public abstract class Shooter extends Unit{
    int arrows;

    /**
     * Это конструктор для класса Стрелок
     * @param name это имя юнита
     * @param attack это очки атаки
     * @param initiative это очки инициативы
     * @param damage это наносимый урон
     * @param arrows это количество стрел у юнита
     */
    public Shooter(String name, int attack, int initiative, int[] damage, int arrows) {
        super(name, 10, 10, 5, attack, initiative, damage);
        this.arrows = arrows;
    }

    public void shoot () {} //метод совершения выстрелов
}
