import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;


public class Part1 {
    public static void main(String[] args) {
        try {
            Map<String,List<Integer>> map = Utils.readInput("resources/input.txt");
            List<Integer> list1 = map.get("list1");
            List<Integer> list2 = map.get("list2");
            if (list1.size() != list2.size()) {
                System.out.println("Lists are of different sizes");
                return;
            }
            Collections.sort(list1);
            Collections.sort(list2);

            int solution = 0;
            for (int i=0;i<list1.size();i++){
                solution += Math.abs(list1.get(i)-list2.get(i));
            }
            System.out.println("The solution is: " +solution);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}