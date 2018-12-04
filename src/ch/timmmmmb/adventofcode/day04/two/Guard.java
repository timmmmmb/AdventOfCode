package ch.timmmmmb.adventofcode.day04.two;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Guard {
    ArrayList<Sleep> sleepcycle = new ArrayList<>();
    int id;
    public Guard(int id){
        this.id = id;
    }

    void sleep(Date start, Date end){
        sleepcycle.add(new Sleep(start,end));
    }

    int getTotalSleepTime(){
        int sum = 0;
        for(Sleep sleep: sleepcycle){
            sum+=sleep.getDuration();
        }
        return sum;
    }

    public String toString(){
        return "Guard:"+id;
    }

    int getSleepMinute(){
        //go through each minute
        int minute = 0;
        int slept = 0;
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");


        for(int i = 0; i<60;i++){
            int times = 0;
            for(Sleep sleep: sleepcycle){
                Date startsleepDate = null;
                try {
                    startsleepDate = formatter.parse(formatter.format(sleep.startsleep));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                if(sleep.checkBetween(startsleepDate.getTime()+i*60000)){
                    times++;
                }
            }
            if(times>slept){
                slept=times;
                minute = i;
            }
        }
        return minute;
    }

    public int getSleepAmountTimes() {
        //go through each minute
        int minute = 0;
        int slept = 0;
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");


        for(int i = 0; i<60;i++){
            int times = 0;
            for(Sleep sleep: sleepcycle){
                Date startsleepDate = null;
                try {
                    startsleepDate = formatter.parse(formatter.format(sleep.startsleep));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                if(sleep.checkBetween(startsleepDate.getTime()+i*60000)){
                    times++;
                }
            }
            if(times>slept){
                slept=times;
                minute = i;
            }
        }
        return slept;
    }
}
