package day11;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Part1 {
    public static void main(String[] args) throws Exception {
        try {
            int solution = 0;
            // List<Integer> input = Utils.readInput("resources/input.txt");
            List<Long> input = Utils.readInput("C:\\Users\\tomas\\Desktop\\Personal\\advent-of-code\\2024\\day11\\resources\\input.txt");

            for( int i = 0; i<25;i++){
                input = treatStonesGroup(input);
            }
            solution += input.size();
            System.out.println("The solution is: " + solution);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }    

    static List<Long> treatStonesGroup(List<Long> stones){
        List<Long> newStoneGroup = new ArrayList<>();
        for(Long stone: stones){
            newStoneGroup.addAll(treatStone(stone));
        }
        return newStoneGroup;
    }

    static List<Long> treatStone(long stone) {
        List<Long> newStones = new ArrayList<>(2);
        if (stone == 0L) {
            newStones.add(1L);
            return newStones;
        }

        String s = Long.toString(stone);
        if ((s.length() & 1) == 0) {
            int mid = s.length() / 2;
            long left  = Long.parseLong(s.substring(0, mid));
            long right = Long.parseLong(s.substring(mid));
            newStones.add(left);
            newStones.add(right);
        } else {
            newStones.add(stone * 2024L); 
        }
        return newStones;
    }
}

