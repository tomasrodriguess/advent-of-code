package day01;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utils {
    public static Map<String,List<Integer>> readInput(String path) throws IOException{
        BufferedReader br;
        Map<String,List<Integer>> map =new HashMap<String,List<Integer>>();
        try {
            br = new BufferedReader(new FileReader(path));

            try {
                String line = br.readLine();
                List<Integer> list1 = new ArrayList<>();
                List<Integer> list2 = new ArrayList<>();

                while (line != null) {
                    List<String> inputs = List.of(line.split("   "));
                    list1.add(Integer.valueOf(inputs.get(0)));
                    list2.add(Integer.valueOf(inputs.get(1)));
                    line = br.readLine();
                }
                map.put("list1",list1);
                map.put("list2",list2);
            } finally {
                br.close();
            }
                } catch (FileNotFoundException e) {

            e.printStackTrace();
        }
        return map;
    }
}
