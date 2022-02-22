package org.academiadecodigo.argicultores;

import org.academiadecodigo.argicultores.maps.Direction;
import org.academiadecodigo.argicultores.maps.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player extends Picture {


    Direction playerDirection;
    Position objectPos = new Position();
    private boolean inGame = false;
    private int points = 0;
    private String image;
    private int playerLives;

    public Player(double v, double v1, String s) {
        super(v, v1, s);
        this.draw();
        image = s;
    }

    public int getPoints() {
        return points;
    }

    public void increasePoints(){
        this.points++;
    }

    public void setPlayerLives(int lives){
        this.playerLives = lives;
    }

    public int getPlayerLives() {
        return playerLives;
    }

    public boolean isInGame(){
        return inGame;
    }

    public Direction getPlayerDirection() {
        return playerDirection;
    }

    @Override
    public void load(String s) {
        super.load(s);
        this.draw();
        image = s;
    }

    @Override
    public int getX() {
        return super.getX();
    }

    @Override
    public int getY() {
        return super.getY();
    }

    public String getImage(){
        return image;
    }
}
