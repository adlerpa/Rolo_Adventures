package org.academiadecodigo.argicultores;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Field {
    private Rectangle gameArea;
    private Picture map;

    public Field() {
        map = new Picture(10,10,"/Users/codecadet/Desktop/RoloAdventures2/resources/AC_Class (1) (1).png");
        map.draw();
        gameArea = new Rectangle(10, 10, 800, 800);
        gameArea.draw();
    }

    public int getRightLimit() {
        return gameArea.getWidth();
    }

    public int getBottoLimit() {
        return gameArea.getWidth();
    }

}
