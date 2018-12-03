package ch.timmmmmb.adventofcode.day03.two;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static boolean[][] positions = new boolean[1000][1000];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("input.txt"));
        ArrayList<Block> blocks = new ArrayList();
        //reads from the input
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            blocks.add(new Block(Integer.parseInt(line.substring(line.indexOf("#")+1,line.indexOf(" @"))),
                    Integer.parseInt(line.substring(line.indexOf("@ ")+2,line.indexOf(","))),
                    Integer.parseInt(line.substring(line.indexOf(",")+1,line.indexOf(":"))),
                    Integer.parseInt(line.substring(line.indexOf(": ")+2, line.indexOf("x"))),
                    Integer.parseInt(line.substring(line.indexOf("x")+1))));
        }

        int i = 0;
        for(Block block:blocks){
            for(int j = i+1;j<blocks.size();j++){
                block.getIntersection(blocks.get(j));
            }
            if(block.isOverlaps()){
                System.out.println("ID: "+block.getId());
                break;
            }
            i++;
        }
    }
}
