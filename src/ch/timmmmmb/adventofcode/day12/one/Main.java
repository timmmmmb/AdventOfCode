package ch.timmmmmb.adventofcode.day12.one;

import java.util.*;

public class Main{
    private static ArrayList<PlantPot> plantPots = new ArrayList <>();
    private static ArrayList<Filter>filters = new ArrayList<>();
    private static final int GENERATIONS = 20;
    private static int potPosition = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("input.txt"));
        for(int i = -GENERATIONS;i<0;i++){
            plantPots.add(new PlantPot(i,false));
        }
        Date startdate = new java.util.Date();
        //add all steps to the array
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if(line.contains("initial state:")){
                line = line.replaceAll("initial state: ","");
                for(int i = 0; i<line.length();i++){
                    plantPots.add(new PlantPot(i,line.charAt(i)=='#'));
                    potPosition++;
                }
            }else if(line.length()!=0){
                filters.add(new Filter(line.charAt(0)=='#',
                        line.charAt(1)=='#',
                        line.charAt(2)=='#',
                        line.charAt(3)=='#',
                        line.charAt(4)=='#',
                        line.charAt(9)=='#'
                        ));
            }
        }
        for(int i = potPosition;i<=potPosition+GENERATIONS;i++){
            plantPots.add(new PlantPot(i,false));
        }
        int value = 0;
        int difference = 0;

        for(int i = 1;i<=GENERATIONS;i++){
            for(int j = 0; j<plantPots.size();j++){
                for(Filter filter:filters){
                    boolean p1 = j > 1 && plantPots.get(j - 2).isPlanted();
                    boolean p2 = j > 0 && plantPots.get(j - 1).isPlanted();
                    boolean p4 = j < plantPots.size() - 1 && plantPots.get(j + 1).isPlanted();
                    boolean p5 = j < plantPots.size() - 2 && plantPots.get(j + 2).isPlanted();
                    filter.useFilter(p1,p2,plantPots.get(j),p4,p5);
                }
            }
            //add a new pot to the right and remove one on the left
            //plantPots.remove(0);
            for(PlantPot plantPot:plantPots){
                plantPot.nextGeneration();
            }
            int newvalue = getSum();
            difference = (newvalue-value);
            System.out.println(difference);
            value = newvalue;
        }
        System.out.println("Summe: "+getSum());
    }

    public static String getPottedPlants(){
        String output = "";
        for(PlantPot plantPot:plantPots) {
            output += plantPot.isPlanted() ? "#" : ".";
        }
        return output;
    }

    public static int getSum(){
        int output = 0;
        for(PlantPot plantPot:plantPots) {
            output += plantPot.isPlanted() ? plantPot.getPosition():0;
        }
        return output;
    }
}
