package ch.timmmmmb.adventofcode.day12.one;

public class Filter {
    private final boolean b1,b2,b3,b4,b5;
    private final boolean setsTo;
    public Filter(boolean b1,boolean b2,boolean b3,boolean b4,boolean b5, boolean setsTo){
        this.b1 = b1;
        this.b2 = b2;
        this.b3 = b3;
        this.b4 = b4;
        this.b5 = b5;
        this.setsTo = setsTo;
    }

    public void useFilter(boolean p1,boolean p2,PlantPot p3,boolean p4,boolean p5){
        if(b1 == p1&&b2 == p2 && p3.isPlanted() == b3&& p4 ==b4 && p5 == b5){
            p3.setNextState(setsTo);
        }
    }

    public String toString(){
        return (b1?"#":".")+(b2?"#":".")+(b3?"#":".")+(b4?"#":".")+(b5?"#":".") +" => "+(setsTo?"#":".");
    }
}
