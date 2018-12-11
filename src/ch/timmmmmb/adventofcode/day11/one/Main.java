package ch.timmmmmb.adventofcode.day11.one;

public class Main {
    private static int[][] coordiantes = new int[301][301];
    private static final int SERIALNUMBER = 7803;
    public static void main(String[] args) {
        for(int i = 1;i<coordiantes.length;i++){
            for(int j = 1;j<coordiantes[i].length;j++){
                int rackid = 10+i;
                int powerlevel = rackid*j;
                powerlevel += SERIALNUMBER;
                powerlevel *= rackid;
                powerlevel = (powerlevel)%1000/100;
                powerlevel -= 5;
                coordiantes[i][j] = powerlevel;
            }
        }
        System.out.println("Maxvalue"+getMaxCoordinates());
    }

    private static int getMaxCoordinates(){
        int maxX = 0;
        int maxY = 0;
        int maxvalue = 0;
        for(int i = 1;i<coordiantes.length-2;i++) {
            for (int j = 1; j < coordiantes[i].length-2; j++) {
                int value = coordiantes[i][j];
                value += coordiantes[i+1][j];
                value += coordiantes[i+2][j];
                value += coordiantes[i][j+1];
                value += coordiantes[i+1][j+1];
                value += coordiantes[i+2][j+1];
                value += coordiantes[i][j+2];
                value += coordiantes[i+1][j+2];
                value += coordiantes[i+2][j+2];
                if(maxvalue<value){
                    maxX = i;
                    maxY = j;
                    maxvalue = value;
                }
                System.out.println(i+","+j);
            }
        }
        System.out.println("Coordinates: "+maxX+":"+maxY);
        return maxvalue;
    }


}
