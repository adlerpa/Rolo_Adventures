package org.academiadecodigo.argicultores;

public class GhostFactory {

    public static final int NUMBER_GHOSTS = 8;


    public static Ghost[] BuildAllGhosts (int x, int y) {

        Ghost[] ghostArray = new Ghost[NUMBER_GHOSTS];
        for (int i = 0; i < NUMBER_GHOSTS; i++){
            if (i < NUMBER_GHOSTS/4) {
                ghostArray[i] = getNewDiogo(x,y);
            } else if (i==2 || i== 3){
                ghostArray[i] = getNewNuno(x,y);
            }
            else if (i== 4 || i == 5){
                ghostArray[i] = getNewAdler(x,y);
            }
            else if (i== 6 || i == 7){
                ghostArray[i] = getNewCamila(x,y);
            }
        }
        return  ghostArray;
    }

    public static Ghost getNewDiogo(int x, int y) {
        Ghost diogo = new Ghost(x,y);
        diogo.setPicture("diogo.png");
        return diogo;
    }
    public static Ghost getNewNuno(int x, int y) {
        Ghost nuno = new Ghost(x,y);
        nuno.setPicture("nuno.png");
        return nuno;
    }
    public static Ghost getNewAdler(int x, int y) {
        Ghost adler = new Ghost(x,y);
        adler.setPicture("adler.png");
        return adler;
    }
    public static Ghost getNewCamila(int x, int y) {
        Ghost camila = new Ghost(x,y);
        camila.setPicture("camila.png");
        return camila;
    }

}
