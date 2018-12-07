package ch.timmmmmb.adventofcode.Day07.two;

import java.util.ArrayList;

public class Step {
    private final String name;
    private Worker worker;
    private ArrayList<Step> prerequisites = new ArrayList<>();
    private boolean finished = false;
    private boolean working = false;
    private int duration = 0;

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

    public void working(int duration, Worker worker){
        this.worker = worker;
        this.duration = duration;
        worker.setWorking(true);
        worker.setWorkingon(this);
        working = true;
    }

    public String work(){
        if(!working)return "";
        this.duration--;
        if(duration==0){
            working = false;
            finish();
            worker.setWorking(false);
            worker.setWorkingon(null);
            return name;
        }
        return "";
    }

    public boolean isWorking() {
        return working;
    }
}
