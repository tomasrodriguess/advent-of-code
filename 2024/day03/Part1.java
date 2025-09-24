package day03;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {
    public static void main(String[] args) {
        try {
            int solution = 0;
            List<String> input = Utils.readInput("resources/input.txt");
            Pattern pattern = Pattern.compile("mul\\([0-9]{1,3},[0-9]{1,3}\\)");
            for (String line: input){
                Matcher matcher = pattern.matcher(line);
                while(matcher.find()){
                    String match = matcher.group();
                    solution += Utils.findAndMultiply(match);
                }
            }
            System.out.println("The solution is: " + solution);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
