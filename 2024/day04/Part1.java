package day04;

import java.io.IOException;

import java.util.List;

public class Part1 {
    public static void main(String[] args) {
        try {
            int solution = 0;
            List<List<Character>> input = Utils.readInput("resources/input.txt");
            String word = new String("XMAS"); //chartAt(i)

            for (int i = 0; i < input.size(); i++){
                for (int j = 0; j < input.get(i).size(); j++){
                    int occurencs =  Utils.findWord(input,word,i,j,1,0) +
                    Utils.findWord(input,word,i,j,0,1)+
                    Utils.findWord(input,word,i,j,-1,0)+
                    Utils.findWord(input,word,i,j,0,-1)+
                    Utils.findWord(input,word,i,j,1,1)+
                    Utils.findWord(input,word,i,j,1,-1)+
                    Utils.findWord(input,word,i,j,-1,-1) +
                    Utils.findWord(input,word,i,j,-1,1);
                    solution+=occurencs;
                }
            }
            System.out.println("The solution is: " + solution);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
