package org.academiadecodigo.argicultores.maps;

public class Position {
    private int x;
    private int y;
    public static final int CELLSIZE = 40;

    public Position() {
    }

    public Position(int xMin,  int yMin) {
        this.x = xMin;
        this.y = yMin;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setPos(int xm,  int ym) {
        x = xm;
        y = ym;
    }
}
