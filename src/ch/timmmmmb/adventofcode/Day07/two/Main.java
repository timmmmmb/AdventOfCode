package ch.timmmmmb.adventofcode.Day07.two;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static String order = "";
    private static ArrayList<Step> steps = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("input.txt"));
        //add all steps to the array
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String name = line.substring(line.indexOf("before step ")+12,line.indexOf(" can"));
            String prerequisitename = line.substring(line.indexOf("Step ")+5,line.indexOf(" must"));
            Step step = getStepByName(name);
            Step prerequisite = getStepByName(prerequisitename);
            if(step == null){
                step = new Step(name);
                steps.add(step);
            }
            if(prerequisite == null){
                prerequisite = new Step(prerequisitename);
                steps.add(prerequisite);
            }
            step.addPrerequisite(prerequisite);
        }

        steps.sort(new StepComparator());
        int time =0;
        ArrayList<Worker> workers = new ArrayList<>();
        int workeramount = 5;
        for(int i = 0;i<workeramount;i++){
            workers.add(new Worker());
        }
        Steps:while(true){
            int duration = 60;
            for(Step step:steps){
                duration++;
                for(Worker worker:workers){
                    if(worker.isWorking())continue;
                    if(step.isPrerequisitesFinished()&&!step.isFinished()&&!step.isWorking()){
                        step.working(duration,worker);
                    }
                }
            }
            //work on all steps
            for(Step step:steps) order += step.work();

            time++;

            for(Worker worker:workers){
                if(worker.isWorking()){
                    continue Steps;
                }
            }
            if(order.length()<steps.size())continue;
            break;
        }
        System.out.println("Time: "+time);
        System.out.println("Result order: "+order);
    }

    private static Step getStepByName(String name){
        for(Step step:steps){
            if(step.getName().equals(name))return step;
        }
        return null;
    }
}
