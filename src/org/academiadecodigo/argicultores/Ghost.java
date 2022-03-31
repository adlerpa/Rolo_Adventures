package org.academiadecodigo.argicultores;

import org.academiadecodigo.argicultores.maps.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Ghost extends Position {

    private Picture picture;
    private String url;

    public Ghost(int x, int y){
        super(x,y);
    }

    public void setPicture(String url){
        this.url = url;
        picture = new Picture(getX(),getY(),url);
        picture.draw();
    }

    public void translate(int x, int y){
        picture.translate(x, y);
    }
}


