package org.example;

/**
 * Это абстрактный класс Стрелок, наследуется от абстрактного класса Юнит
 */
public abstract class Shooter extends Unit{
    int maxArrows;
    int curArrows;

    /**
     * Это конструктор для класса Стрелок
     * @param attack это очки атаки
     * @param initiative это очки инициативы
     * @param damage это наносимый урон
     * @param maxArrows это максимальное количество стрел у юнита
     * @param curArrows это текущее количество стрел у юнита
     */
    public Shooter(int attack, int initiative, int[] damage, int maxArrows, int curArrows) {
        super(10, 10, 5, attack, initiative, damage);
        this.maxArrows = maxArrows;
        this.curArrows = curArrows;
    }

    public void shoot () {} //метод совершения выстрелов
}
