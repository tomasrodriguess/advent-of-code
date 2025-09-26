package day05;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Part2 {
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
                solution+=fixInvalidUpdates(rules_map,update);
            }
            System.out.println("The solution is: " + solution);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static int fixInvalidUpdates(Map<Integer,List<Integer>> rules,List<Integer> update){
        List<Integer> pages_checked = new ArrayList<>();
        for(Integer page: update){
            try {
                List<Integer> happen_after_list = rules.get(page);
                for(int happen_after: happen_after_list ){
                    if(pages_checked.contains(happen_after)){
                        List<Integer> orderedList = reorderUpdateWithCorrectRules(rules, update);
                        return  Utils.returnMiddle(orderedList);
                    }
                }
                
                pages_checked.add(page);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        return 0;
    }

    public static List<Integer> reorderUpdateWithCorrectRules(Map<Integer,List<Integer>> rules,List<Integer> update){
        List<Integer> returnList = new ArrayList<>();

        for(Integer page: update){
            try {
                boolean added = false;
                List<Integer> happen_after_list = rules.get(page);
                int last_insert = -1;
                for(int happen_after: happen_after_list ){
                    int position = returnList.indexOf(happen_after);
                    if(position != -1){
                        if(last_insert !=-1 && position<last_insert){
                            returnList.remove(last_insert);
                        }
                        if(position<last_insert || last_insert == -1){
                            returnList.add(position, page);
                            last_insert = position;
                            added = true;
                        }                       
                    }
                }

                if(!added){
                    returnList.add(page);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return returnList;
    }
}
