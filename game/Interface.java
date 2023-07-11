package org.game;

import java.util.ArrayList;

public interface Interface {
    void step(ArrayList<Unit> list);  //метод выполнения хода
    String getInfo();  //метод получения информации о юните
    String getName();  //метод получения имени юнита
}
