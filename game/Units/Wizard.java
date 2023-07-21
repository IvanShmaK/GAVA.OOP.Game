package org.game.Units;

import java.util.ArrayList;
import java.util.Comparator;

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
        super(10, 10, 8, 2, new float[]{-1, -3}, x, y);
        this.maxMana = this.curMana = 100;
    }

    /**
     * Это метод получения информации об экземпляре класса волшебник
     * @return строку, содержащую общую информацию из класса Unit, плюс количество маны
     */
    @Override
    public String getInfo() {
        return String.format("%s; Mana %d/%d", super.getInfo(), this.curMana, this.maxMana);
    }

    /**
     * Это метод выполнения хода волшебников. Если волшебник жив (curHP > 0) и у него есть мана (curMana > 0), то он
     * находит среди своих союзников наиболее поврежденного юнита и лечит его. Если волшебник никого не лечит на данном ходу,
     * он может восстановить ману.
     * @param enemiesList это список юнитов-противников
     * @param friendsList это список юнитов-союзников
     */
    @Override
    public void step(ArrayList<Unit> friendsList, ArrayList<Unit> enemiesList) {
        if (this.curHP == 0) return;
        friendsList.sort(Comparator.comparingInt(o -> o.curHP));
        //friendsList.forEach(n -> System.out.println(n.name + n.curHP));
        Unit tempUnit = null;
        for (int i = 0; i < friendsList.size(); i++) {
            if (friendsList.get(i).curHP > 0) {
                tempUnit = friendsList.get(i);
                break;
            }
        }
        if (this.curMana >= 20 && tempUnit.curHP < tempUnit.maxHP) {
            tempUnit.getDamage(this.damage);
            this.state = "treated";
            this.curMana -= 20;
//            System.out.println("Волшебник " + this.name + " полечил " + tempUnit.name + "[" +
//                    tempUnit.coord.x + ", " + tempUnit.coord.y + "], здоровья у него стало " +
//                    tempUnit.curHP + " маны у него самого стало " + this.curMana);
        } else if (this.curMana + 20 < this.maxMana){
            if (this.curMana + 20 < this.maxMana) this.curMana += 20;
            else this.curMana = this.maxMana;
            //System.out.println("Волшебник " + this.name + " никого не лечил, восстановил ману, ее у него стало " + this.curMana);
        } //else System.out.println("Волшебнику " + this.name + " восстановления маны не требовалось");
    }
}
