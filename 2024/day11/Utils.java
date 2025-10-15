package day11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    

    public static List<Long> readInput(String path) throws IOException {
    List<Long> output = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(path))) {
        String line;
        while ((line = br.readLine()) != null) {
            if (line.isBlank()) continue;
            String[] toks = line.trim().split("\\s+");
            for (String t : toks) {
                output.add(Long.parseLong(t));
            }
        }
    }
    return output;
    }
}
