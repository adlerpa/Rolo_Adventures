package org.academiadecodigo.argicultores.maps.obstacles;


import org.academiadecodigo.argicultores.maps.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Obstacles extends Picture {

    Position objectPos = new Position();

    public Obstacles(int x, int y) {
        objectPos.setPos(x, y);
    }

    public Obstacles() {
    }

    public int getPosX() {
        return objectPos.getX();
    }

    public int getPosY() {
        return objectPos.getY();

    }
}