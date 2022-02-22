package org.academiadecodigo.argicultores;

import org.academiadecodigo.argicultores.maps.ColisionDetector;
import org.academiadecodigo.argicultores.maps.Direction;
import org.academiadecodigo.argicultores.maps.Position;
import org.academiadecodigo.argicultores.maps.obstacles.Obstacles;

public class GDirection {
    private Field field;
    private Position pos;
    Obstacles[] allObstacles;
    private Ghost ghost;
    ColisionDetector colisionDetector;

    public GDirection(Field field) {
        this.field = field;
    }

    public void moveUp() {
        if (pos.getY() - Position.CELLSIZE <= Field.MARGIN || colisionDetector.blockMovement((Ghost)pos, Direction.UP)) {
            moveGhost(pos);
        } else {
            pos.setPos(pos.getX(),pos.getY()-Position.CELLSIZE);
        }
    }
    public void moveDown() {
        if (pos.getY() + Position.CELLSIZE >= field.getBottomLimit() || colisionDetector.blockMovement((Ghost)pos, Direction.DOWN)) {
            moveGhost(pos);
        } else {
            pos.setPos(pos.getX(),pos.getY() + Position.CELLSIZE);
        }
    }
    public void moveRigth() {
        if (pos.getX() + Position.CELLSIZE >= field.getRightLimit() || colisionDetector.blockMovement((Ghost) pos, Direction.RIGHT)) {
            moveGhost(pos);
        } else {
            pos.setPos(pos.getX() + Position.CELLSIZE,pos.getY());
        }
    }
    public void moveLeft() {
        if (pos.getX() - Position.CELLSIZE <= Field.MARGIN || colisionDetector.blockMovement((Ghost) pos, Direction.LEFT)) {
            moveGhost(pos);
        } else {
            pos.setPos(pos.getX() - Position.CELLSIZE,pos.getY());
        }
    }
    public void moveGhost(Position pos) {
        this.pos = pos;
        int direction = (int) Math.floor(Math.random()*4);
        switch (direction) {
            case 0:
                moveUp();
                break;
            case 1:
                moveDown();
                break;
            case 2:
                moveRigth();
                break;
            case 3:
                moveLeft();
                break;
        }
        ((Ghost) pos).delete();
        ((Ghost) pos).draw();
    }
    public void setColisionDetector(ColisionDetector colisionDetector) {
        this.colisionDetector = colisionDetector;
    }
}