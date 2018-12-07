package ch.timmmmmb.adventofcode.Day07.two;

public class Worker {
    private boolean working = false;
    private Step workingon = null;

    public boolean isWorking() {
        return working;
    }

    public void setWorking(boolean working) {
        this.working = working;
    }

    public Step getWorkingon() {
        return workingon;
    }

    public void setWorkingon(Step workingon) {
        this.workingon = workingon;
    }
}
