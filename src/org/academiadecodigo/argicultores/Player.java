package org.academiadecodigo.argicultores;

import org.academiadecodigo.argicultores.maps.Direction;
import org.academiadecodigo.argicultores.maps.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player extends Picture {


    Direction playerDirection;
    Position objectPos = new Position();
    private boolean inGame = false;
    private int points = 0;

    public void increasePoints(){
        this.points++;
    }

    public boolean isInGame(){
        return inGame;
    }

    public Direction getPlayerDirection() {
        return playerDirection;
    }

    public Player(double v, double v1, String s) {
        super(v, v1, s);
        this.draw();
    }


    //METHODS
    @Override
    public void load(String s) {
        super.load(s);
        this.draw();
    }

    @Override
    public int getX() {
        return super.getX();
    }

    @Override
    public int getY() {
        return super.getY();
    }
}
