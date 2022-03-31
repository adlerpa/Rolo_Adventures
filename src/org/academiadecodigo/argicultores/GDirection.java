package org.academiadecodigo.argicultores;

import org.academiadecodigo.argicultores.maps.ColisionDetector;
import org.academiadecodigo.argicultores.maps.Direction;
import org.academiadecodigo.argicultores.maps.Position;
import org.academiadecodigo.argicultores.maps.obstacles.Obstacles;

public class GDirection {
    private Field field;
    private Position pos;
    ColisionDetector colisionDetector;

    public GDirection(Field field) {
        this.field = field;
    }

    public void moveGhost(Position pos) {
        this.pos = pos;
        int direction = (int) Math.floor(Math.random()*4);
        switch (direction) {
            case 0:
                if(moveUp()){
                    ((Ghost) pos).translate(0, -40);
                }

                break;
            case 1:
                if(moveDown()){
                    ((Ghost) pos).translate(0, 40);
                    break;
                }

            case 2:
                if(moveRigth()){
                    ((Ghost) pos).translate( 40, 0);
                    break;
                }

            case 3:
                if(moveLeft()){
                    ((Ghost) pos).translate(-40, 0);
                    break;
                }

        }
    }
    public void setColisionDetector(ColisionDetector colisionDetector) {
        this.colisionDetector = colisionDetector;
    }

    public boolean moveUp() {
        if (pos.getY() - Position.CELLSIZE <= Field.MARGIN || colisionDetector.blockMovement((Ghost)pos, Direction.UP)) {
            return false;

        } else {
            pos.setPos(pos.getX(),pos.getY()-Position.CELLSIZE);
            return true;
        }
    }
    public boolean moveDown() {
        if (pos.getY() + Position.CELLSIZE >= field.getBottomLimit() || colisionDetector.blockMovement((Ghost)pos, Direction.DOWN)) {
            return false;

        } else {
            pos.setPos(pos.getX(),pos.getY() + Position.CELLSIZE);
            return true;
        }
    }
    public boolean moveRigth() {
        if (pos.getX() + Position.CELLSIZE >= field.getRightLimit() || colisionDetector.blockMovement((Ghost) pos, Direction.RIGHT)) {
            return false;

        } else {
            pos.setPos(pos.getX() + Position.CELLSIZE,pos.getY());
            return true;
        }
    }
    public boolean moveLeft() {
        if (pos.getX() - Position.CELLSIZE <= Field.MARGIN || colisionDetector.blockMovement((Ghost) pos, Direction.LEFT)) {
            return false;

        } else {
            pos.setPos(pos.getX() - Position.CELLSIZE,pos.getY());
            return true;
        }
    }
}