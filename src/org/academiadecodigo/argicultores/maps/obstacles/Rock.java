package org.academiadecodigo.argicultores.maps.obstacles;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Rock extends Obstacles {
    private Picture box;
    private double PosX;
    private double PosY;

    public Rock(double PosX, double PosY){
        box = new Picture(PosX, PosY, "../RoloAdventures2/resources/rock.png");
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