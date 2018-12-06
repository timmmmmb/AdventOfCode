package ch.timmmmmb.adventofcode.day06.one;

public class Point {
    private final String id;
    private int x,y;
    private int distance;
    public Point(String id, int x, int y){
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public Point(String id, int x, int y, int distance){
        this.distance = distance;
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getId() {
        return id;
    }

    public String toString(){
        return id;
    }

    public int getDistance(){
        return distance;
    }
}
