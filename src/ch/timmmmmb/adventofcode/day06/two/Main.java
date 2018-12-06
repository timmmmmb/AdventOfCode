package ch.timmmmmb.adventofcode.day06.two;

import java.util.*;

public class Main {
    private static ArrayList<Point> points = new ArrayList<>();

    private static Point[][] coordinates;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("input.txt"));
        int id = 0;
        //adds all the coordinates
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            points.add(new Point(Integer.toString(id),Integer.valueOf(line.substring(0,line.indexOf(","))),Integer.valueOf(line.substring(line.indexOf(", ")+2))));
            id++;
        }
        int maxX=0,maxY=0;
        for(Point point:points){
            if(point.getX()>maxX){
                maxX = point.getX();
            }
            if(point.getY()>maxY){
                maxY = point.getY();
            }
        }
        coordinates = new Point[maxX+2][maxY+2];
        System.out.println("Amount of save Area: "+getAmountOfPointsClose(10000));
    }

    public static int getAmountOfPointsClose(int maxdistance){
        int amount = 0;
        for(int j = 0; j < coordinates.length; j++){
            for (int i = 0; i < coordinates[0].length; i++) {
                int distance = 0;
                for(Point point: points){
                    distance+=Math.abs(point.getX()-j)+Math.abs(point.getY()-i);
                }
                if(distance<maxdistance){
                    amount++;
                }
            }
        }
        return amount;
    }


}
