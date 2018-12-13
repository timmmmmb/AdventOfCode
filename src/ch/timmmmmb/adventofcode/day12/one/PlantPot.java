package ch.timmmmmb.adventofcode.day12.one;

public class PlantPot {
    private final int position;
    private boolean planted = false;
    private boolean nextState = false;

    public PlantPot(int position, boolean hasPlant){
        this.planted = hasPlant;
        this.position = position;
    }

    public void setNextState(boolean nextState) {
        this.nextState = nextState;
    }

    public void nextGeneration(){
        planted = nextState;
        nextState = false;
    }

    public boolean isPlanted() {
        return planted;
    }

    public String toString(){
        return "ID: "+position+" planted: "+planted;
    }

    public int getPosition() {
        return position;
    }
}
