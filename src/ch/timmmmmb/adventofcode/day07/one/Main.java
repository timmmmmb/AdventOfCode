package ch.timmmmmb.adventofcode.day07.one;

import java.util.ArrayList;
import java.util.Collections;
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
        Collections.sort(steps, new StepComparator());
        Steps:while(steps.size()>order.length()){
            for(Step step:steps){
                if(step.isPrerequisitesFinished()&&!step.isFinished()){
                    order+=step.getName();
                    step.finish();
                    continue Steps;
                }
            }
        }
        System.out.println("Result order: "+order);
    }

    private static Step getStepByName(String name){
        for(Step step:steps){
            if(step.getName().equals(name))return step;
        }
        return null;
    }
}
