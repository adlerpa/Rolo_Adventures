package org.academiadecodigo.argicultores.maps;

import org.academiadecodigo.argicultores.Game;
import org.academiadecodigo.argicultores.Ghost;
import org.academiadecodigo.argicultores.Player;
import org.academiadecodigo.argicultores.Sound;
import org.academiadecodigo.argicultores.maps.obstacles.Obstacles;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class ColisionDetector {

    Player player1;
    Obstacles[] allObstacles;
    Points[] allPoints;
    Ghost[] allGhosts;
    Ghost ghost;
    Position pos;
    Game game;
    Sound sound;

    //para os ghosts
    public ColisionDetector(Obstacles[] allObstacles) {
        this.allObstacles = allObstacles;
    }

    public boolean blockMovement(Ghost ghost, Direction direction) {

        switch (direction) {
            case RIGHT:
                for (Obstacles o : allObstacles) {
                    if (ghost.getY() == o.getPosY() && ghost.getX() == o.getPosX() - Position.CELLSIZE) {
                        return true;
                    }
                }
                return false;
            case LEFT:
                for (Obstacles o : allObstacles) {
                    if (ghost.getX() == o.getPosX() + Position.CELLSIZE && ghost.getY() == o.getPosY()) {
                        return true;
                    }
                }
                return false;
            case UP:
                for (Obstacles o : allObstacles) {
                    if (ghost.getY() == o.getPosY() + Position.CELLSIZE && ghost.getX() == o.getPosX()) {
                        return true;
                    }
                }
                return false;
            case DOWN:
                for (Obstacles o : allObstacles) {
                    if (ghost.getY() == o.getPosY() - Position.CELLSIZE && ghost.getX() == o.getPosX()) {
                        return true;
                    }
                }
                return false;
            default:
                return false;
        }
    }

    public ColisionDetector(Obstacles[] allObstacles, Player player) {
        this.allObstacles = allObstacles;
        this.player1 = player;
    }

    public ColisionDetector(Points[] allPoints, Player player) {
        this.allPoints = allPoints;
        this.player1 = player;
    }


    public ColisionDetector(Points[] allPoints, Player player, Game game ){
        this.allPoints = allPoints;
        this.player1 = player;
        this.game = game;
    }

    public ColisionDetector(Ghost[] allGhosts, Player player, Game game ){
        this.allGhosts = allGhosts;
        this.player1 = player;
        this.game = game;
    }


    public boolean unSafe() {

        switch (player1.getPlayerDirection()) {
            case RIGHT:
                for (Obstacles o : allObstacles) {
                    if (player1.getY() == o.getPosY() && player1.getX() == o.getPosX() - 40) {
                        return true;
                    }
                }
                return false;
            case LEFT:
                for (Obstacles o : allObstacles) {
                    if (player1.getX() == o.getPosX() + 40 && player1.getY() == o.getPosY()) {
                        return true;
                    }
                }
                return false;
            case UP:
                for (Obstacles o : allObstacles) {
                    if (player1.getY() == o.getPosY() + 40 && player1.getX() == o.getPosX()) {
                        return true;
                    }
                }
                return false;
            case DOWN:
                for (Obstacles o : allObstacles) {
                    if (player1.getY() == o.getPosY() - 40 && player1.getX() == o.getPosX()) {
                        return true;
                    }
                }
                return false;
            default:
                return false;
        }
    }


    public void drinkTheBeer() {
        for (Points o : allPoints) {
            if (player1.getY() == o.getPosY() && player1.getX() == o.getPosX()) {
                if(o.isExists()) {
                    player1.increasePoints();
                    sound = new Sound("getItemSound.wav");
                }
                //o.setImage("empty.png");
                o.setImage();
            }
        }
    }

    public void loseLife(){
        for(Ghost g: allGhosts){
            if (player1.getX() == g.getX() && player1.getY() == g.getY()){
                player1.setPlayerLives(player1.getPlayerLives()-1);
                game.eraseHearts();
            }
        }
    }
}
