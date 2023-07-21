package org.game.Units;

import org.game.Name;

import java.util.ArrayList;
import java.util.Random;

/**
 * Это класс-прототип всех юнитов
 */
public abstract class Unit implements Interface {
    protected String name;
    protected int maxHP, curHP, attack;
    public int initiative;
    protected float[] damage;
    protected Coordinates coord;
    protected String state;

    /**
     * Это конструктор класса Юнит. Имя ему выбирается рандомно из списка имен (файл Name.java)
     * @param maxHP это максимальное здоровье юнита
     * @param curHP это текущее здоровье юнита
     * @param attack это очки атаки юнита
     * @param initiative это очки инициативы юнита
     * @param damage это уровень наносимого урона
     * @param x это координата по оси х
     * @param y это координата по оси у
     */
    public Unit(int maxHP, int curHP, int attack, int initiative, float[] damage, int x, int y) {
        this.name = String.valueOf(Name.values()[new Random().nextInt(Name.values().length)]);
        this.maxHP = maxHP;
        this.curHP = curHP;
        this.attack = attack;
        this.initiative = initiative;
        this.damage = damage;
        coord = new Coordinates(x, y);
        this.state = "stand";
    }

    /**
     * Это метод получения информации о юните.
     * @return строку, содержащую класс и имя юнита, его здоровье, инициативу и состояние
     */
    @Override
    public String getInfo() {
        return String.format("%s %s [%d, %d]; HP: %d/%d; Init:%d: Status:%s", this.getClass().getSimpleName(), this.name,
                this.coord.x, this.coord.y, curHP, maxHP, this.initiative, this.state);
    }

    /**
     * Это метод по нахождению ближайшего вражеского юнита для того юнита, у которого данный метод вызывается
     * @param units это список вражеских юнитов
     * @return массив, первым элементом которого будет расстояние до ближайшего вражеского юнита, а вторым - его индекс
     * в передаваемом списке
     */
    public double[] nearest (ArrayList<Unit> units) {
        double[] tempArr = new double[2];
        tempArr[0] = Double.MAX_VALUE;
        for (int i = 0; i < units.size(); i++) {
            if (coord.findDistance(units.get(i).coord) < tempArr[0] && units.get(i).curHP > 0){
                tempArr[0] = coord.findDistance(units.get(i).coord);
                tempArr[1] = i;
            }
        }
        return tempArr;
    }

    /**
     * Это метод получения урона юнитом. Он принимает на вход массив из значений повреждения (damage у атакующего
     * юнита), затем у юнита от текущего здоровья отнимается урон (средний). Текущее здоровье не может быть меньше 0
     * (если это так, юнит погибает). ЕслиЕсли значения отрицательные - реализуется эффект лечения (текущее здоровье
     * увеличивается на размер урона, но не более максимального здоровья).
     * @param array это параметр damage у атакующего юнита
     */
    @Override
    public void getDamage(float[] array) {
        float damage = (array[0] + array[1]) / 2;
        if (this.curHP - damage > 0 && this.curHP - damage <= maxHP) {
            this.curHP -= damage;
        } else if (this.curHP - damage > maxHP) {
            this.curHP = maxHP;
        } else {
            this.curHP = 0;
            this.state = "dead";
        }
    }

    /**
     * Это метод получения координат юнита.
     * @return массив из двух элементов, в котором первым элементом является координата х, а вторым - координата у
     */
    public int[] getCoords () {
        int[] coordArray = new int[2];
        coordArray[0] = this.coord.x;
        coordArray[1] = this.coord.y;
        return coordArray;
    }

    /**
     * Это метод получения текущего здоровья юнита
     * @return текущее здоровье юнита
     */
    public float getHp () {
        return this.curHP;
    }

    /**
     * Это метод, который определяет, жив ли юнит
     * @return false, если юнит жив, либо true, если мертв
     */
    public boolean isDead () {
        return this.state.equals("dead");
    }
}

