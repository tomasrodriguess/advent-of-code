package day05;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utils {
    public static Map<String,List<List<Integer>>> readInput(String path) throws IOException{
        BufferedReader br;
        Map<String,List<List<Integer>>> output =new HashMap<String,List<List<Integer>>>();
        try {
            br = new BufferedReader(new FileReader(path));

            try {
                String line = br.readLine();
                List<List<Integer>> rules =new ArrayList<>();
                List<List<Integer>> updates = new ArrayList<>();

                while (line != null) {
                    List<String> inputs = List.of(line.split("\\|"));
                    if(inputs.size() == 2){
                        List<Integer> rulesList =  new ArrayList<>();
                        for(String s : inputs) rulesList.add(Integer.valueOf(s));
                        rules.add(rulesList);
                    }else if(!inputs.get(0).isEmpty()){
                        List<String> rule_split = Arrays.asList(line.split(","));
                        List<Integer> intList =  new ArrayList<>();
                        for(String s : rule_split) intList.add(Integer.valueOf(s));
                        updates.add(intList);
                    }
                    line = br.readLine();
                }
                output.put("rules",rules);
                output.put("updates",updates);
            } finally {
                br.close();
            }
                } catch (FileNotFoundException e) {

            e.printStackTrace();
        }
        return output;
    }

    public static int returnMiddle(List<Integer> list){
        return list.get(list.size()/2);
    }

    public static int checkIfUpdateIsValid(Map<Integer,List<Integer>> rules,List<Integer> update){
        List<Integer> pages_checked = new ArrayList<>();
        for(Integer page: update){
            try {
                List<Integer> happen_after_list = rules.get(page);
                for(int happen_after: happen_after_list ){
                    if(pages_checked.contains(happen_after)){
                        return 0;
                    }
                }
                
                pages_checked.add(page);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        return Utils.returnMiddle(update);
    }
}
