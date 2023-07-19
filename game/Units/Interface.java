package org.game.Units;

import java.util.ArrayList;

public interface Interface {
    void step(ArrayList<Unit> list1, ArrayList<Unit> list2);  //метод выполнения хода
    String getInfo();  //метод получения информации о юните
    String getName();  //метод получения имени юнита
    void getDamage(float[] array);  //метод получения юнитом урона
}
