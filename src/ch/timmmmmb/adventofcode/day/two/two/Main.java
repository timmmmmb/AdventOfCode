package ch.timmmmmb.adventofcode.day.two.two;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("input.txt"));
        ArrayList<String> input = new ArrayList<>();
        while (scanner.hasNext()) {
            input.add(scanner.next());
        }
        for(int index = 0;index<input.size()-1;index++){
            line:for(int i = index+1;i<input.size();i++){
                boolean difference = false;
                for(int j=0;j<input.get(i).length();j++){
                    //vergleiche jeden buchstaben
                    if(input.get(i).charAt(j)!=input.get(index).charAt(j)){
                        if(difference){
                            continue line;
                        }else{
                            difference = true;
                        }
                    }
                }
                //die beiden sind identisch
                System.out.println(input.get(i)+" "+input.get(index));
            }
        }

    }
}
