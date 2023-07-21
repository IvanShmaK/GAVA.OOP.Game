package org.game.Units;

/**
 * Класс Coordinates, который отвечает за координаты юнитов на игровом поле. Здесь же находятся методы с математическими
 * расчетами взаимодействия между юнитами
 */
public class Coordinates {
    int x, y;

    /**
     * Это конструктор класса Coordinates
     * @param x это координата по оси х
     * @param y это координата оп оси у
     */
    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Метод по расчету расстояния между двумя юнитами. Координаты первого юнита берутся у того юнита, у которого
     * вызывается данный метод
     * @param coordinates это координаты второго юнита
     * @return искомое расстояние по формуле из теоремы Пифагора
     */
    public double findDistance (Coordinates coordinates) {
        int dx = coordinates.x - x;
        int dy = coordinates.y - y;
        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }

    /**
     * Это метод расчета координат поля, в которые пойдет юнит. Если по оси х расстояние больше, юнит пойдет по оси х,
     * Если нет - то по оси у.
     * @param targetPosition это координаты ближайшего противника
     * @return координаты клетки, на которую будет сделан ход
     */
    public Coordinates newPosition (Coordinates targetPosition) {
        Coordinates newCoord = new Coordinates(x, y);
        if (Math.abs(targetPosition.x - x) > Math.abs(targetPosition.y - y)) {
            if (targetPosition.x - x > 0) newCoord.x++;
            else newCoord.x--;
        } else {
            if (targetPosition.y - y > 0) newCoord.y++;
            else newCoord.y--;
        }
        return newCoord;
    }
}
