package org.academiadecodigo.argicultores;

import org.academiadecodigo.argicultores.maps.ColisionDetector;
import org.academiadecodigo.argicultores.maps.Direction;
import org.academiadecodigo.argicultores.maps.Map;
import org.academiadecodigo.argicultores.maps.Points;
import org.academiadecodigo.argicultores.maps.obstacles.Obstacle;
import org.academiadecodigo.argicultores.maps.obstacles.Obstacles;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Game implements KeyboardHandler {
    private Field field;
    private Player rolo;
    private Map map = new Map();
    Obstacles[] allObstacles;
    Points[] allPoints;


    public void init() {
        //MENU, OPTIONS
    }

    public void start() {
        field = new Field();
        rolo = new Player(10, 10, "../RoloAdventures2/resources/rolo.png");
        allObstacles = map.levelOneObs();
        allPoints = map.levelOnePoints();
        controls();
    }


    public void controls() {
        Keyboard kb = new Keyboard(this);

        KeyboardEvent right = new KeyboardEvent();
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        right.setKey(KeyboardEvent.KEY_RIGHT);
        kb.addEventListener(right);

        KeyboardEvent left = new KeyboardEvent();
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        left.setKey(KeyboardEvent.KEY_LEFT);
        kb.addEventListener(left);

        KeyboardEvent up = new KeyboardEvent();
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        up.setKey(KeyboardEvent.KEY_UP);
        kb.addEventListener(up);

        KeyboardEvent down = new KeyboardEvent();
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        down.setKey(KeyboardEvent.KEY_DOWN);
        kb.addEventListener(down);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        ColisionDetector colisionDetector = new ColisionDetector(allObstacles, rolo);
        ColisionDetector beerDetector = new ColisionDetector(allPoints, rolo);
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                rolo.playerDirection = Direction.RIGHT;

                if (rolo.getX() <= field.getRightLimit() - 40 && !colisionDetector.unSafe()) {
                    rolo.translate(40, 0);
                    beerDetector.drinkTheBeer();
                }
                break;
            case KeyboardEvent.KEY_LEFT:
                rolo.playerDirection = Direction.LEFT;

                if (rolo.getX() >= 40 && !colisionDetector.unSafe()) {
                    rolo.translate(-40, 0);
                    beerDetector.drinkTheBeer();
                }
                break;
            case KeyboardEvent.KEY_UP:
                rolo.playerDirection = Direction.UP;

                if (rolo.getY() >= 40 && !colisionDetector.unSafe()) {
                    rolo.translate(0, -40);
                    beerDetector.drinkTheBeer();
                }
                break;
            case KeyboardEvent.KEY_DOWN:
                rolo.playerDirection = Direction.DOWN;
                beerDetector.drinkTheBeer();
                if (rolo.getY() <= field.getBottoLimit() - 40 && !colisionDetector.unSafe()) {
                    rolo.translate(0, 40);
                    beerDetector.drinkTheBeer();
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
