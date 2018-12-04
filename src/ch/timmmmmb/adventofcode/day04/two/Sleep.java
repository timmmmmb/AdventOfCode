package ch.timmmmmb.adventofcode.day04.two;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Sleep {
    Date startsleep, endsleep;
    public Sleep(Date startsleep,Date endsleep){
        this.startsleep = startsleep;
        this.endsleep = endsleep;
    }

    public long getDuration(){
        long diffInMillies = endsleep.getTime() - startsleep.getTime();
        return TimeUnit.MINUTES.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }

    public boolean checkBetween(long minute){
        return minute >= startsleep.getTime() && minute<endsleep.getTime();
    }
}
