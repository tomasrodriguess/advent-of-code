package day03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    public static List<String> readInput(String path) throws IOException{
        BufferedReader br;
        List<String> output = new ArrayList<>();
        try {
            br = new BufferedReader(new FileReader(path));
            
            try {
                String line = br.readLine();
                 while (line != null) {
                    output.add(line);
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

    public static int findAndMultiply(String match){
        Pattern pattern_numbers = Pattern.compile("[0-9]{1,3}");
        Matcher matcher_numbers = pattern_numbers.matcher(match);
        List<Integer> n = new ArrayList<>();
        while(matcher_numbers.find()){
            n.add(Integer. parseInt(matcher_numbers.group()));
        }
        if(n.size() ==2){
            return n.get(0)*n.get(1);
        }else{
            return 0;
        }

    }
}
