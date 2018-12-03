package ch.timmmmmb.adventofcode.day02.one;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(Main.class.getResourceAsStream("input.txt"));
            int twotimes = 0;
            int threetimes = 0;
            while (scanner.hasNext()) {
                String line = scanner.next();
                boolean twotimesb = false, threetimesb = false;
                while(line.length()>=1){
                    int count = line.length() - line.replaceAll(String.valueOf(line.charAt(0)),"").length();
                    line = line.replaceAll(String.valueOf(line.charAt(0)),"");
                    if(count == 2)twotimesb = true;
                    if(count == 3)threetimesb = true;
                }
                if(twotimesb)twotimes++;
                if(threetimesb)threetimes++;
            }
            System.out.println("Checksum: "+(twotimes*threetimes));

    }
}
