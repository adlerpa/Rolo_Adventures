package org.academiadecodigo.argicultores.maps.obstacles;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Box extends Obstacles {

    private Picture box;
    private double PosX;
    private double PosY;

    public Box(double PosX, double PosY){
        box = new Picture(PosX, PosY, "/Users/codecadet/Desktop/RoloAdventures2/resources/empty.png");
        this.PosX = PosX;
        this.PosY = PosY;
        box.draw();
    }


    public int getPosX() {
        return (int)PosX;
    }

    public int getPosY() {
        return (int)PosY;
    }

}
