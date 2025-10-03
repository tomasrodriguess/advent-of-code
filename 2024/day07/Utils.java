package day07;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {
    public static List<Equation> readInput(String path) throws IOException{
        BufferedReader br;
        List<Equation> output =new ArrayList<Equation>();
        try {
            br = new BufferedReader(new FileReader(path));

            try {
                String line = br.readLine();

                while (line != null) {
                    String[] inputs =line.split(":");
                    Long result = Long.parseLong(inputs[0]);
                    List<Integer> numbers= Arrays.stream(inputs[1].trim().split("\\s+"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
                    output.add(new Equation(result,numbers));
                    line = br.readLine();
                }
            } finally {
                br.close();
            }
                } catch (FileNotFoundException e) {

            e.printStackTrace();
        }
        return output;
    }
}
final class Equation{
    public Long result;
    public List<Integer> numbers;

    public Equation(Long result,List<Integer> numbers){
        this.result = result;
        this.numbers = numbers;
    }
}
