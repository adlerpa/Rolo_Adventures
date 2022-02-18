package org.academiadecodigo.argicultores.maps;

public class Position {
    private int x;
    private int y;
//    private int xMax;
  //  private int yMax;


    public Position() {
    }

    public Position(int xMin,  int yMin) {
        this.x = xMin;
 //       this.xMax = xMax;
        this.y = yMin;
  //      this.yMax = yMax;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

  /*  public int getXMax() {
        return xMax;
    }

    public int getYMax() {
        return yMax;
    }
*/
    public void setPos(int xm,  int ym) {
        x = xm;
      //  xMax = xM;
        y = ym;
       // yMax = yM;
    }
}
