package day05;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Part1 {
    public static void main(String[] args) {
        try {
            int solution = 0;
            Map<String,List<List<Integer>>> input = Utils.readInput("resources/input.txt");
            
            List<List<Integer>> rules = input.get("rules");

            Map<Integer,List<Integer>> rules_map = new HashMap<Integer,List<Integer>>();
            for(List<Integer> s : rules){
                List<Integer> value = rules_map.get(s.get(0));
                if (value != null) {
                    int rule = s.get(1);
                    value.add(rule);
                    rules_map.put(s.get(0),value);
;                } else {
                    List<Integer> newList = new ArrayList<>();
                    newList.add(s.get(1));
                    rules_map.put(s.get(0), newList);
                }
            } 

            List<List<Integer>> updates = input.get("updates");
            for(List<Integer> update : updates){
                solution+= Utils.checkIfUpdateIsValid(rules_map,update);
            }
            System.out.println("The solution is: " + solution);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
