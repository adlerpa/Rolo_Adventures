package org.academiadecodigo.argicultores.maps;

import org.academiadecodigo.argicultores.Player;
import org.academiadecodigo.argicultores.maps.obstacles.Obstacle;
import org.academiadecodigo.argicultores.maps.obstacles.Obstacles;

public class ColisionDetector {

    Player player1;
    Obstacles[] allObstacles;
    Points[] allPoints;

    public ColisionDetector(Obstacles[] allObstacles, Player player) {
        this.allObstacles = allObstacles;
        this.player1 = player;
    }

    public ColisionDetector(Points[] allPoints, Player player) {
        this.allPoints = allPoints;
        this.player1 = player;
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
                o.setImage("/Users/codecadet/Desktop/RoloAdventures2/resources/empty.png");
                player1.increasePoints();

            }
        }
    }
}
