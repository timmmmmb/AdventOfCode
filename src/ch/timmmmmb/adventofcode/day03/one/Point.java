package ch.timmmmmb.adventofcode.day03.one;

class Point {
    int x,y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return "Point "+x+":"+y;
    }
}
