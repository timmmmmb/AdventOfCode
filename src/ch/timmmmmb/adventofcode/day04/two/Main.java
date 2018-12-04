package ch.timmmmmb.adventofcode.day04.two;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

public class Main {
    private static ArrayList<DateEvent> events = new ArrayList<>();
    private static ArrayList<Guard> guards = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("input.txt"));
        //reads from the input
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            events.add(new DateEvent(line));
        }
        //sort the list of events
        events.sort(Comparator.comparing(o -> o.date));

        int id;
        Guard guard = null;
        Date startsleep = null;
        Date endsleep = null;
        for (DateEvent event : events) {
            if (event.description.contains("Guard")) {
                id = Integer.parseInt(event.description.substring(event.description.indexOf("#") + 1, event.description.indexOf(" begins")));
                guard = getGuardByID(id);
                if (guard == null) {
                    guard = new Guard(id);
                    guards.add(guard);
                }
            }
            if (event.description.contains("falls asleep")) {
                startsleep = event.date;
            }
            if (event.description.contains("wakes up")) {
                endsleep = event.date;
                guard.sleep(startsleep,endsleep);
            }
        }
        Guard resultguard = getMostSleepyOnSameTime();
        System.out.println("Guard: "+resultguard.id +"\nAmount slept on same minute: "+resultguard.getSleepAmountTimes() +"\nMinute: "+resultguard.getSleepMinute()+"\nResult: "+resultguard.id*resultguard.getSleepMinute());
    }

    private static Guard getGuardByID(int id){
        for(Guard guard: guards){
            //guard allready exists
            if(guard.id==id){
                return guard;
            }
        }
        return null;
    }

    private static Guard getLongSleeper(){
        Guard longestsleeper = null;
        int sleepduration = 0;
        //get the guard with the longest sleep
        for(Guard guard: guards){
            int sleep = guard.getTotalSleepTime();
            if(sleep>sleepduration){
                longestsleeper = guard;
                sleepduration = sleep;
            }
        }
        return longestsleeper;
    }

    private static Guard getMostSleepyOnSameTime(){
        Guard allwayssametimeSleeper = null;
        int amountsslept = 0;
        for(Guard guard: guards){
            int sleep = 0;
            sleep = guard.getSleepAmountTimes();
            if(sleep>amountsslept){
                allwayssametimeSleeper = guard;
                amountsslept = sleep;
            }
        }
        return allwayssametimeSleeper;

    }
}
