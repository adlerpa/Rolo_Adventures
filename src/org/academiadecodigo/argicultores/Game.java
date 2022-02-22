package org.academiadecodigo.argicultores;

import org.academiadecodigo.argicultores.maps.ColisionDetector;
import org.academiadecodigo.argicultores.maps.Direction;
import org.academiadecodigo.argicultores.maps.Map;
import org.academiadecodigo.argicultores.maps.Points;
import org.academiadecodigo.argicultores.maps.obstacles.Obstacles;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game implements KeyboardHandler {
    private Field field;
    private Player rolo;
    private Map map = new Map();
    private GDirection gdirection;
    private boolean running;
    Obstacles[] allObstacles;
    Points[] allPoints;
    Text scoreText = new Text(720, 830, "Score ");
    Picture lives1;
    Picture lives2;
    Picture lives3;
    Ghost[] ghostArray;
    ColisionDetector beerDetector;
    ColisionDetector colisionDetector;
    ColisionDetector checkDeath;
    Sound sound;
    private boolean gameOver = false;
    private Field gameOverField;


    public Player getRolo() {
        return rolo;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public void init() {
        field = new Field("menu.png");
        running = false;
    }

    public void drawHearts() {
        lives1 = new Picture(20, 815, "heart.png");
        lives2 = new Picture(70, 815, "heart.png");
        lives3 = new Picture(120, 815, "heart.png");
        lives1.draw();
        lives2.draw();
        lives3.draw();
    }

    public void drawScore() {
        scoreText.delete();
        scoreText = new Text(720, 830, "Score " + rolo.getPoints());
        scoreText.draw();
        scoreText.grow(30, 20);

    }

    public void eraseHearts() {
        if (rolo.getPlayerLives() == 2) {
           // lives3.delete();
            lives3.load("emptyheart.png");
        }
        if (rolo.getPlayerLives() == 1) {
           // lives2.delete();
            lives2.load("emptyheart.png");
        }
        if (rolo.getPlayerLives() == 0) {
           // lives1.delete();
            lives1.load("emptyheart.png");
            running = false;
            Picture gameOverPic = new Picture(10, 10, "gameover.jpg");
            gameOverPic.draw();
            sound.stop();
            sound = new Sound("gameoversound.wav");

            for (Ghost g : ghostArray) {
                g.setPicture("empty.png");
            }
        }
    }

    public Sound getSound() {
        return sound;
    }

    public void setSound(Sound sound) {
        this.sound = sound;
    }

    public void start() throws InterruptedException {

        field.getMap().delete();
        field = new Field("acfinal.png");
        rolo = new Player(10, 10, "right1.png");
        rolo.setPlayerLives(3);
        drawHearts();
        drawScore();
        allObstacles = map.levelOneObs();
        allPoints = map.levelOnePoints();

        sound = new Sound("funnybitbackground.wav");

        colisionDetector = new ColisionDetector(allObstacles, rolo);
        beerDetector = new ColisionDetector(allPoints, rolo);
        running = true;
        this.gdirection = new GDirection(field);
        ghostArray = GhostFactory.BuildAllGhosts(570, 450);
        ColisionDetector ghostsObstacles = new ColisionDetector(allObstacles);
        checkDeath = new ColisionDetector(ghostArray, rolo, this);
        gdirection.setColisionDetector(ghostsObstacles);
        while (isRunning()) {
            Thread.sleep(400);
            for (Ghost g : ghostArray) {
                gdirection.moveGhost(g);
            }
        }
    }

    public void moveGhosts() throws InterruptedException {
        while (isRunning()) {
            Thread.sleep(400);
            for (Ghost g : ghostArray) {
                gdirection.moveGhost(g);
            }
        }
    }

    public GDirection getGdirection() {
        return gdirection;
    }

    public Ghost[] getGhostArray() {
        return ghostArray;
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

        KeyboardEvent esc = new KeyboardEvent();
        esc.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        esc.setKey(KeyboardEvent.KEY_ESC);
        kb.addEventListener(esc);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                rolo.playerDirection = Direction.RIGHT;
                if (rolo.getX() <= field.getRightLimit() - 40 && !colisionDetector.unSafe()) {
                    rolo.translate(40, 0);
                    if (rolo.getImage() == "right1.png") {
                        rolo.load("right2.png");
                    } else {
                        rolo.load("right1.png");
                    }
                    beerDetector.drinkTheBeer();
                    checkDeath.loseLife();
                    drawScore();
                    if(rolo.getPoints() >= 30){
                        victory();
                    }
                }
                break;

            case KeyboardEvent.KEY_LEFT:
                rolo.playerDirection = Direction.LEFT;

                if (rolo.getX() >= 40 && !colisionDetector.unSafe()) {
                    rolo.translate(-40, 0);
                    if (rolo.getImage() == "left1.png") {
                        rolo.load("left2.png");
                    } else {
                        rolo.load("left1.png");
                    }
                    beerDetector.drinkTheBeer();
                    checkDeath.loseLife();
                    drawScore();
                    if(rolo.getPoints() >= 30){
                        victory();
                    }
                }
                break;

            case KeyboardEvent.KEY_UP:
                rolo.playerDirection = Direction.UP;


                if (rolo.getY() >= 40 && !colisionDetector.unSafe()) {
                    rolo.translate(0, -40);
                    if (rolo.getImage() == "up1.png") {
                        rolo.load("up2.png");
                    } else {
                        rolo.load("up1.png");
                    }
                    beerDetector.drinkTheBeer();
                    checkDeath.loseLife();
                    drawScore();
                    if(rolo.getPoints() >= 30){
                        victory();
                    }
                }
                break;

            case KeyboardEvent.KEY_DOWN:
                rolo.playerDirection = Direction.DOWN;
                beerDetector.drinkTheBeer();
                if (rolo.getY() <= field.getBottomLimit() - 40 && !colisionDetector.unSafe()) {
                    rolo.translate(0, 40);
                    if (rolo.getImage() == "down1.png") {
                        rolo.load("down2.png");
                    } else {
                        rolo.load("down1.png");
                    }
                    beerDetector.drinkTheBeer();

                    checkDeath.loseLife();
                    drawScore();
                    if(rolo.getPoints() >= 30){
                        victory();
                    }
                }
                break;

            case KeyboardEvent.KEY_ESC:

                System.exit(0);
                break;
        }
    }

    public Field getField() {
        return this.field;
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    public void victory() {

        sound.stop();
        sound = new Sound("levelclear.wav");
        Picture gameOverPic = new Picture(10, 10, "victory1.png");
        gameOverPic.draw();
        for (Ghost g : ghostArray) {
            g.setPicture("empty.png");
        }
        this.setRunning(false);
    }
}

