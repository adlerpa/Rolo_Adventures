package org.academiadecodigo.argicultores;

import org.academiadecodigo.simplegraphics.graphics.Text;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();
        game.controls();
        game.init();

        game.start();

        /*if(game.getRolo().getPoints())
        game.drawHearts();
        game.drawScore();*/
    }
}
