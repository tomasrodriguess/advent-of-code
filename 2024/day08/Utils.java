package day08;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static List<List<Character>> readInput(String path) throws IOException{
        BufferedReader br;
        List<List<Character>> output = new ArrayList<>();
        try {
            br = new BufferedReader(new FileReader(path));
            
            try {
                String line = br.readLine();
                 while (line != null) {
                    List<Character> chars = new ArrayList<Character>();
                    for (char c : line.toCharArray()) {
                        chars.add(c);
                    }
                    output.add(chars);
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
