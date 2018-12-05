package ch.timmmmmb.adventofcode.day05.one;
import ch.timmmmmb.adventofcode.day04.one.DateEvent;
import ch.timmmmmb.adventofcode.day04.one.Guard;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

public class Main {
    static String regex = "";
    public static void main(String[] args) {
        String line = "";
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("input.txt"));
        //reads from the input
        while (scanner.hasNext()) {
            line = scanner.nextLine();
        }
        getRegex();
        String output = getUpdatedString(line);
        System.out.println("Output: "+output+"\nLength: "+output.length());
    }
    public static String getUpdatedString(String input){
        String output = input.replaceAll(regex,"");
        if(output.length()==input.length())return output;
        return getUpdatedString(output);
    }

    public static void getRegex(){
        String lookfor = "aAAabBBbcCCcdDDdeEEefFFfgGGghHHhiIIijJJjkKKklLLlmMMmnNNnoOOopPPpqQQqrRRrsSSstTTtuUUuvVVvwWWwxXXxyYYyzZZz";
        char[] chars = lookfor.toCharArray();
        boolean or = false;
        for (int i = 0, n = chars.length; i < n; i++) {
            regex += or?chars[i]+"|":chars[i];
            or = !or;
        }

    }
}
