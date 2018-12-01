package ch.timmmmmb.adventofcode.day.one.two;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        ArrayList<Integer> frequencies = new ArrayList<>();
        int sum = 0;
        frequencies.add(sum);
        outer:while(true){
            Scanner scanner = new Scanner(Main.class.getResourceAsStream("input.txt"));
            while(scanner.hasNextInt()){
                sum += scanner.nextInt();
                for(Integer frequencie:frequencies){
                    if(frequencie == sum){
                        System.out.println("Result: "+sum);
                        break outer;
                    }
                }
                frequencies.add(sum);
            }
        }
    }
}
