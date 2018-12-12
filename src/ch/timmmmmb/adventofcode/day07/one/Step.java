package ch.timmmmmb.adventofcode.day07.one;

import java.util.ArrayList;

public class Step {
    private final String name;
    private ArrayList<Step> prerequisites = new ArrayList<>();
    private boolean finished = false;

    public Step(String name){
        this.name = name;
    }

    public boolean isPrerequisitesFinished(){
        for(Step prerequisite:prerequisites){
            if(!prerequisite.isFinished()){
                return false;
            }
        }
        return true;
    }

    public boolean isFinished() {
        return finished;
    }

    public String getName() {
        return name;
    }

    public void addPrerequisite(Step prerequisite){
        prerequisites.add(prerequisite);
    }

    public void finish(){
        finished = true;
    }
}
