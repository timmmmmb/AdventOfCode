package ch.timmmmmb.adventofcode.Day07.two;

import java.util.Comparator;

public class StepComparator implements Comparator<Step> {
    @Override
    public int compare(Step o1, Step o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

