package day07;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Part2 {
        public static void main(String[] args) {
        try {
            Long solution = (long) 0;
            // List<Equation> input = Utils.readInput("resources/input.txt");
            List<Equation> input = Utils.readInput("C:\\Users\\tomas\\Desktop\\Personal\\advent-of-code\\2024\\day07\\resources\\input.txt");

            for(Equation equation:input){
                Long result = equation.result;
                if (validExpresion(result,equation.numbers)) solution +=result;
            }
            System.out.println("The solution is: " + solution);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean validExpresion(Long result, List<Integer> numbers){
        List<Long> results = new ArrayList<>();
        results.add(Long.valueOf(numbers.get(0).longValue()));
        for(int i = 1;i<numbers.size();i++){
            results = testAll(results,Long.valueOf(numbers.get(i).longValue()));
        }
        return results.contains(result);
    }
    public static List<Long> testAll(List<Long> results, Long number){
        List<Long> result= new ArrayList<>();
        for(int i = 0;i<results.size();i++){
            result.add(results.get(i)+number);
            result.add(results.get(i)*number);
            Long conc= Long.parseLong(Long.toString(results.get(i)) + Long.toString(number));
            result.add(conc);
        }
        return result;
    }
}
