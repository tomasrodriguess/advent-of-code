package day02;

import java.io.IOException;
import java.util.List;

public class Part2 {
     public static void main(String[] args) {
        try {
            int solution = 0;
            List<List<Integer>> input = Utils.readInput("resources/input.txt");
            for(List<Integer> report : input){
                if(Utils.isSafeReport(report,true)){
                    solution++;
                }
            }
            System.out.println("The solution is: " + solution);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
