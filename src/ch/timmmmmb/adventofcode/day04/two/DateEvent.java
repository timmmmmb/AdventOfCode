package ch.timmmmmb.adventofcode.day04.two;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateEvent {
    String description;
    Date date;
    public DateEvent(String input){
        try {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(input.substring(input.indexOf("[")+1,input.indexOf("]")));
            description = input.substring(input.indexOf("] ")+2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String toString(){
        return "["+date+"] "+description;
    }
}
