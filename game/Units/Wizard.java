package org.game.Units;

import java.util.ArrayList;

/**
 * Это абстрактный класс Волшебник, наследуется от класса Юнит. Лечит дружественных юнитов. Его наследники (классы Монах
 * и Маг) получают параметры: максимальное здоровье 10, защита 3, атака 8, инициатива 2, максимальное количество маны 100
 */
public abstract class Wizard extends Unit{
    protected int maxMana, curMana;

    /**
     * Это конструктор для класса волшебник
     * @param x это координата по оси х
     * @param y это координата по оси у
     */
    public Wizard(int x, int y) {
        super(10, 10, 3, 8, 2, new float[]{-1, -5}, x, y);
        this.maxMana = this.curMana = 100;
    }

    /**
     * Это метод выполнения хода волшебников. Если волшебник жив (curHP > 0) и у него есть мана (curMana > 0), то он
     * находит среди своих союзников наиболее поврежденного юнита (того, у которого разница между максимальным и
     * текущим здоровьем самая большая) и лечит его на величину урона. Если волшебник никого не лечит на данном ходу,
     * он может восстановить ману в размере половины от затрачиваемой на одно лечение.
     * @param enemiesList это список юнитов-противников
     * @param friendsList это список юнитов-союзников
     */
    @Override
    public void step(ArrayList<Unit> friendsList, ArrayList<Unit> enemiesList) {
//        System.out.printf("Ближайший к %s противник - %s, расстояние до него - %.1f%n", this.getName(),
//                enemiesList.get((int)nearest(enemiesList)[1]).getName(), nearest(enemiesList)[0]);
        System.out.println(this.getInfo());
        if (this.curHP == 0 || this.curMana == 0) return;
        friendsList.sort(((o1, o2) -> (int) ((int) (o2.maxHP - o2.curHP) - (o1.maxHP - o1.curHP))));
        if (friendsList.get(0).curHP > 0 && friendsList.get(0).curHP < friendsList.get(0).maxHP) {
            friendsList.get(0).getDamage(this.damage);
            this.state = "treated";
            this.curMana -= 20;
            System.out.println("    " + this.getName() + " лечит " + friendsList.get(0).getName() + ", здоровье у него " +
                    "становится " + friendsList.get(0).curHP + ", маны у " + this.getName() + " становится " + this.curMana);
            return;
        }
        System.out.println("Лечения никому не требовалось");
        if (this.curMana < this.maxMana) {
            if (this.curMana + 20 < this.maxMana) this.curMana += 20;
            else this.curMana = this.maxMana;
            System.out.println(this.getName() + " восстанавливает ману, её у него становится " + this.curMana);
        }
    }
}
