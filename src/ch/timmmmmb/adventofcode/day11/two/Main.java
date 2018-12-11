package ch.timmmmmb.adventofcode.day11.two;

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
        System.out.println("Maxvalue: "+getMaxCoordinates());
    }

    private static int getMaxCoordinates(){
        int maxX = 0;
        int maxY = 0;
        int maxvalue = 0;
        int maxsize = 0;
        for(int size = 1; size < 301;size++){
            for(int i = 1;i<coordiantes.length-size;i++) {
                for (int j = 1; j < coordiantes[i].length-size; j++) {
                    int value = 0;
                    for(int i2 = 0;i2 <size;i2++){
                        for(int j2 = 0;j2<size;j2++){
                            value += coordiantes[i+i2][j+j2];
                        }
                    }
                    if(maxvalue<value){
                        maxX = i;
                        maxY = j;
                        maxvalue = value;
                        maxsize = size;
                    }
                }
            }
        }
        System.out.println("Coordinates: "+maxX+","+maxY+","+maxsize);
        return maxvalue;
    }


}
