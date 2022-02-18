package org.academiadecodigo.argicultores.maps;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Points extends Picture {
    private Picture points;
    private double PosX;
    private double PosY;

    public Points(double PosX, double PosY){
        points = new Picture(PosX, PosY, "../RoloAdventures2/resources/beer.png");
        this.PosX = PosX;
        this.PosY = PosY;
        points.draw();
    }

    public void setImage(String s){
        points.load(s);
        points.draw();
    }

    public int getPosX() {
        return (int)PosX;
    }

    public int getPosY() {
        return (int)PosY;
    }

    public void deleteImg(){
        super.delete();
        this.delete();
    }
}
