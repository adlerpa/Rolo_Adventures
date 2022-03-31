package org.academiadecodigo.argicultores;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Field {
    private Rectangle gameArea;
    private Picture map;
    public static final int MARGIN = 10;
    private String s;

    public Field(String s) {
        map = new Picture(10,10,s);
        map.draw();
        this.s = s;
        gameArea = new Rectangle(10, 10, 800, 850);
        gameArea.draw();
    }

    public int getRightLimit() {
        return gameArea.getWidth();
    }

    public int getBottomLimit() {
        return gameArea.getWidth();
    }

}
