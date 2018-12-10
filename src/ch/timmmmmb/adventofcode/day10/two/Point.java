package ch.timmmmmb.adventofcode.day10.two;

import javafx.scene.shape.Rectangle;

public class Point extends Rectangle {
    private int x,y,xspeed,yspeed;
    public Point(int x, int y, int xspeed, int yspeed){
        super(x*10+200,y*10+200,1*10,1*10);
        this.x =x*10-1100;
        this.y =y*10-1100;
        this.xspeed = xspeed*10;
        this.yspeed = yspeed*10;
    }

    public void move(){
        x += xspeed;
        y += yspeed;
        this.setY(y);
        this.setX(x);
    }
}
