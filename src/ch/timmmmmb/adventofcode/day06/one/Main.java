package ch.timmmmmb.adventofcode.day06.one;

import java.util.*;

public class Main {
    private static ArrayList<Point> newpoints = new ArrayList<>();
    private static ArrayList<Point> temppoints = new ArrayList<>();
    private static ArrayList<Point> rootpoints = new ArrayList<>();

    private static Point[][] coordinates;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("input.txt"));
        int id = 0;
        //adds all the coordinates
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            newpoints.add(new Point(Integer.toString(id),Integer.valueOf(line.substring(0,line.indexOf(","))),Integer.valueOf(line.substring(line.indexOf(", ")+2))));
            id++;
        }
        int maxX=0,maxY=0;
        for(Point point:newpoints){
            if(point.getX()>maxX){
                maxX = point.getX();
            }
            if(point.getY()>maxY){
                maxY = point.getY();
            }
        }
        coordinates = new Point[maxX+2][maxY+2];
        rootpoints.addAll(newpoints);
        addNewPoints();

        removeAllborderPoints();
        System.out.println("Area: "+getMaxArea());
    }

    private static void printGrid()    {
        for(int i = 0; i < coordinates[0].length-1; i++)
        {
            for (Point[] coordinate : coordinates) {
                System.out.printf("%5s ", coordinate[i]);
            }
            System.out.println();
        }
    }

    private static void addNewPoints(){
        for(Point newpoint:newpoints){
            if(coordinates[newpoint.getX()][newpoint.getY()] == null){
                coordinates[newpoint.getX()][newpoint.getY()] = new Point(newpoint.getId(),newpoint.getX(),newpoint.getY());
                addFollower(newpoint);
                //check if the point is allready taken, if its taken by another point that hasnt your points id and is not a placeholder
            }else if(coordinates[newpoint.getX()][newpoint.getY()]!=null&& !coordinates[newpoint.getX()][newpoint.getY()].getId().equals(".")&&!coordinates[newpoint.getX()][newpoint.getY()].getId().equals(newpoint.getId())){
                //check if both are the same distance apart
                Point allreadyplaced = coordinates[newpoint.getX()][newpoint.getY()];
                Point newpointroot = getPointByID(newpoint.getId());
                if(newpointroot==null)throw new NullPointerException("root not found");
                Point allreadyplacedroot = getPointByID(allreadyplaced.getId());
                if(allreadyplacedroot==null)throw new NullPointerException("root not found");
                double distancexallreadyplaced = allreadyplacedroot.getX()-allreadyplaced.getX();
                double distanceyallreadyplaced = allreadyplacedroot.getY()-allreadyplaced.getY();
                double allreadyDistance = Math.abs(distancexallreadyplaced)+Math.abs(distanceyallreadyplaced);

                double newpointrootX = newpointroot.getX()-newpoint.getX();
                double newpointrootY = newpointroot.getY()-newpoint.getY();
                double newdistance = Math.abs(newpointrootY)+Math.abs(newpointrootX);


                if(allreadyDistance==newdistance){
                    coordinates[newpoint.getX()][newpoint.getY()] = new Point(".",newpoint.getX(),newpoint.getY(),(int)newdistance);
                    addFollower(newpoint);
                }else if(allreadyDistance>newdistance){
                    coordinates[newpoint.getX()][newpoint.getY()] = new Point(newpoint.getId(),newpoint.getX(),newpoint.getY());
                    addFollower(newpoint);
                }
            }else if(coordinates[newpoint.getX()][newpoint.getY()]!=null&& coordinates[newpoint.getX()][newpoint.getY()].getId().equals(".")&&!coordinates[newpoint.getX()][newpoint.getY()].getId().equals(newpoint.getId())){
                //check if both are the same distance apart
                Point allreadyplaced = coordinates[newpoint.getX()][newpoint.getY()];
                Point newpointroot = getPointByID(newpoint.getId());
                double allreadyDistance = allreadyplaced.getDistance();

                if(newpointroot==null)throw new NullPointerException("root not found");
                double newpointrootX = newpointroot.getX()-newpoint.getX();
                double newpointrootY = newpointroot.getY()-newpoint.getY();
                double newdistance = Math.abs(newpointrootY)+Math.abs(newpointrootX);


                if(allreadyDistance>newdistance){
                    coordinates[newpoint.getX()][newpoint.getY()] = new Point(newpoint.getId(),newpoint.getX(),newpoint.getY());
                    addFollower(newpoint);
                }
            }
        }
        //make newpoints = temppoints
        newpoints.clear();
        newpoints = temppoints;
        if(newpoints.size()!=0){
            temppoints = new ArrayList<>();
            addNewPoints();
        }
    }

    private static void addFollower(Point newpoint){
        //add all the next points
        if(newpoint.getX()-1>=0) temppoints.add(new Point(newpoint.getId(),newpoint.getX()-1, newpoint.getY()));
        if(newpoint.getX()-1>=0&&newpoint.getY()+1<coordinates[0].length) temppoints.add(new Point(newpoint.getId(),newpoint.getX()-1,newpoint.getY()+1));
        if(newpoint.getY()-1>=0) temppoints.add(new Point(newpoint.getId(), newpoint.getX(),newpoint.getY()-1));
        if(newpoint.getX()+1<coordinates.length&&newpoint.getY()-1>=0) temppoints.add(new Point(newpoint.getId(),newpoint.getX()+1,newpoint.getY()-1));
        if(newpoint.getX()+1<coordinates.length) temppoints.add(new Point(newpoint.getId(),newpoint.getX()+1, newpoint.getY()));
        if(newpoint.getX()-1>=0&&newpoint.getY()-1>=0) temppoints.add(new Point(newpoint.getId(),newpoint.getX()-1,newpoint.getY()-1));
        if(newpoint.getY()+1<coordinates[0].length) temppoints.add(new Point(newpoint.getId(), newpoint.getX(),newpoint.getY()+1));
        if(newpoint.getX()+1<coordinates.length&&newpoint.getY()+1<coordinates[0].length) temppoints.add(new Point(newpoint.getId(),newpoint.getX()+1,newpoint.getY()+1));
    }

    private static Point getPointByID(String id){
        for(Point point: rootpoints){
            if(point.getId().equals(id))return point;
        }
        return null;
    }

    private static void removeAllborderPoints(){
        Set<String> toberemoved = new HashSet<>();
        for(int j = 0; j < coordinates.length; j++){
            for (int i = 0; i < coordinates[0].length; i++) {
                if(i == 0|| i == coordinates[0].length-1||j==0||j == coordinates.length-1){
                    toberemoved.add(coordinates[j][i].getId());
                }
            }
        }
        toberemoved.add(".");
        for(int i = 0; i < coordinates.length; i++){
            point:for (int j = 0; j < coordinates[0].length; j++) {
                for(String remove:toberemoved){
                    if(coordinates[i][j].getId().equals(remove)){
                        coordinates[i][j] = null;
                        continue point;
                    }
                }
            }
        }
        for(String remove:toberemoved){
            Iterator pointIterator = rootpoints.iterator();
            while(pointIterator.hasNext()){
                Point point = (Point)pointIterator.next();
                if(point.getId().equals(remove)){
                    pointIterator.remove();
                }
            }
        }
    }

    private static int getMaxArea(){
       int maxsize = 0;
       String id;
       for(Point rootpoint:rootpoints){
           int size = 0;
           for(int i = 1; i < coordinates[0].length-1; i++)
           {
               for (Point[] coordinate : coordinates) {
                   if(coordinate[i]!=null&&coordinate[i].getId().equals(rootpoint.getId())){
                       size++;
                   }
               }
           }
           if(size>maxsize){
               maxsize=size;
               id = rootpoint.getId();
           }
       }
       return maxsize;
    }
}
