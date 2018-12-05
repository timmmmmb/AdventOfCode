package ch.timmmmmb.adventofcode.day05.two;

import java.util.Scanner;

public class Main {
    static String regex = "";
    public static void main(String[] args) {
        String line = "";
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("input.txt"));
        //reads from the input
        while (scanner.hasNext()) {
            line = scanner.nextLine();
        }
        getRegex();
        String lookfor = "abcdefghijklmnopqrstuvwxyz";
        char[] chars = lookfor.toCharArray();
        String output = getUpdatedString(line);
        String result ="";
        Character charcterreplaced = 'a';
        int length = output.length();
        for(int i = 0, n = chars.length; i < n; i++){
            String replaced = line.replaceAll("(?i)"+chars[i],"");
            output = getUpdatedString(replaced);
            if(output.length()<length){
                charcterreplaced = chars[i];
                length = output.length();
                result = output;
            }
        }
        System.out.println("Output: "+result+"\nLength: "+result.length());
    }
    public static String getUpdatedString(String input){
        String output = input.replaceAll(regex,"");
        if(output.length()==input.length())return output;
        return getUpdatedString(output);
    }

    public static void getRegex(){
        String lookfor = "aAAabBBbcCCcdDDdeEEefFFfgGGghHHhiIIijJJjkKKklLLlmMMmnNNnoOOopPPpqQQqrRRrsSSstTTtuUUuvVVvwWWwxXXxyYYyzZZz";
        char[] chars = lookfor.toCharArray();
        boolean or = false;
        for (int i = 0, n = chars.length; i < n; i++) {
            regex += or?chars[i]+"|":chars[i];
            or = !or;
        }

    }
}
