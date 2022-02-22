package org.academiadecodigo.argicultores.maps;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Points extends Picture {
    private Picture points;
    private double PosX;
    private double PosY;
    private boolean exists = true;

    public Points(double PosX, double PosY){
        points = new Picture(PosX, PosY, "beer.png");

        this.PosX = PosX;
        this.PosY = PosY;
        points.draw();
    }

    public boolean isExists() {
        return exists;
    }

    public void setImage(){
        this.exists = false;
        points.delete();
        //points.load(s);
        //points.draw();
    }

    public Picture getImage(){
        return points;
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
