package org.academiadecodigo.argicultores.maps;

import org.academiadecodigo.argicultores.maps.obstacles.Box;
import org.academiadecodigo.argicultores.maps.obstacles.Obstacle;
import org.academiadecodigo.argicultores.maps.obstacles.Obstacles;
import org.academiadecodigo.argicultores.maps.obstacles.Rock;

public class Map {
    Obstacles[] oneObs;
    Points[] onePoints;

    public Obstacles[] levelOneObs() {
        oneObs = new Obstacles[]{
                new Box(130, 90),
                new Box(50, 130),
                new Box(50, 170),
                new Box(50, 210),
                new Box(50, 290),
                new Box(50, 330),
                new Box(50, 370),
                new Box(130, 250),
                new Box(130, 410),
                new Box(130, 570),
                new Box(530, 50),
                new Box(570, 50),
                new Box(650, 90),
                new Box(730, 410),
                new Box(650, 250),
                new Box(730, 250),
                new Box(650, 410),
                new Box(650, 490),
                new Box(690, 490),
                new Box(730, 490),
                new Box(770, 490),
                new Box(650, 530),
                new Box(650, 570),
                new Box(650, 610),
                new Box(650, 730),
                new Box(650, 770),
                new Box(730, 570),
                new Box(730, 730),
                new Box(650, 690),

                new Box(250, 130),
                new Box(290, 130),
                new Box(330, 130),
                new Box(370, 130),
                new Box(410, 130),
                new Box(450, 130),
                new Box(490, 130),

                new Box(250, 250),
                new Box(290, 250),
                new Box(330, 250),
                new Box(370, 250),
                new Box(410, 250),
                new Box(450, 250),
                new Box(490, 250),

                new Box(250, 370),
                new Box(290, 370),
                new Box(330, 370),
                new Box(370, 370),
                new Box(410, 370),
                new Box(450, 370),
                new Box(490, 370),

                new Box(250, 490),
                new Box(290, 490),
                new Box(330, 490),
                new Box(370, 490),
                new Box(410, 490),
                new Box(450, 490),
                new Box(490, 490),

                new Box(250, 610),
                new Box(290, 610),
                new Box(330, 610),
                new Box(370, 610),
                new Box(410, 610),
                new Box(450, 610),
                new Box(490, 610),

                new Box(250, 770),
                new Box(290, 770),
                new Box(330, 770),
                new Box(370, 770),
                new Box(410, 770),
                new Box(450, 770),
                new Box(490, 770),

                new Box(50, 770),
                new Box(90, 770),
                new Box(130, 770),
                new Box(170, 770),
                new Box(210, 770)
        };
        return oneObs;
    }

    public Points[] levelOnePoints() {
        onePoints = new Points[]{
                new Points(370, 50),
                new Points(570, 10),
                new Points(690, 90),
                new Points(130, 170),
                new Points(370, 170),
                new Points(690, 250),
                new Points(370, 290),
                new Points(130, 330),
                new Points(370, 410),
                new Points(130, 490),
                new Points(370, 530),
                new Points(770, 530),
                new Points(130, 650),
                new Points(370, 690),
                new Points(770, 770),

                new Points(690, 770),
                new Points(690, 530),
                new Points(770, 650),
                new Points(770, 450),
                new Points(10, 770),
                new Points(10, 50),
                new Points(770, 10),
                new Points(690, 170),
                new Points(690, 410),
                new Points(50, 250),
                new Points(10, 730),
                new Points(50, 730),
                new Points(570, 770),
                new Points(90, 730),
                new Points(610, 770),
        };
        return onePoints;
    }
}
