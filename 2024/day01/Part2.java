package day01;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Part2 {
    public static void main(String[] args) {
         try {
            Map<String,List<Integer>> map = Utils.readInput("resources/input.txt");
            List<Integer> list1 = map.get("list1");
            List<Integer> list2 = map.get("list2");
            if (list1.size() != list2.size()) {
                System.out.println("Lists are of different sizes");
                return;
            }
            
            Map<Integer,Integer> counter = new HashMap<Integer,Integer>();
            int solution = 0;
            for (int i=0;i<list1.size();i++){
                if (counter.containsKey(list1.get(i))){
                    solution += counter.get(list1.get(i));
                }else{
                    int similarity = Collections.frequency(list2, list1.get(i)) * list1.get(i);
                    counter.put(list1.get(i),similarity);
                     solution += similarity;
                }
            }
            System.out.println("The solution is: " +solution);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
