package ch.timmmmmb.adventofcode.day09.two;

import java.util.ArrayList;

public class Main {
    private static ArrayList<Integer> circle = new ArrayList<>();
    private static ArrayList<Integer> players = new ArrayList<>();
    private static final int MAXPLAYER = 471;
    private static final int MAXVALUE = 72026;
    public static void main(String[] args) {
        for(int i = 1; i<=MAXPLAYER;i++){
            players.add(0);
        }
        int currentmarbleposition = 0;
        circle.add(0);
        for(int i = 1;i<=MAXVALUE*100;i++){
            if(i%23==0){
                int currentplayer = i%MAXPLAYER;
                players.set(currentplayer,players.get(currentplayer)+i);
                int removalposition = currentmarbleposition -7;
                if(removalposition<0)removalposition+=circle.size();
                players.set(currentplayer,players.get(currentplayer)+circle.get(removalposition));
                circle.remove(removalposition);
                currentmarbleposition = removalposition;
            }else{
                currentmarbleposition = (currentmarbleposition+2)%circle.size();
                circle.add(currentmarbleposition,i);
            }
        }
        System.out.println("Maxvalue: "+getMaxplayer());
    }

    /**
     * used to get the value from the player
     */
    private static int getMaxplayer(){
        int maxvalue = 0;
        for(int playervalue: players){
            if(playervalue>maxvalue)maxvalue=playervalue;
        }
        return  maxvalue;
    }
}
