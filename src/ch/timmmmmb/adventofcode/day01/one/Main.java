package ch.timmmmmb.adventofcode.day01.one;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("input.txt"));
        int sum = 0;
        while(scanner.hasNextInt()){
            sum += scanner.nextInt();
        }
        System.out.println("Result:"+sum);
    }
}
