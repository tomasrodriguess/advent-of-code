package day10;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    

    public static List<List<Integer>> readInput(String path) throws IOException{
        BufferedReader br;
        List<List<Integer>> output = new ArrayList<>();
        try {
            br = new BufferedReader(new FileReader(path));
            
            try {
                String line = br.readLine();
                while (line != null) {
                    List<Integer> ints = new ArrayList<>(line.length());
                    for (int i = 0; i < line.length(); i++) {
                        char ch = line.charAt(i);
                        ints.add(ch - '0');
                    }
                    output.add(ints);
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
