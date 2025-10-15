package day11;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Part2 {
    
    static record Key(long stone, int k) {}
    static final Map<Key, BigInteger> memo = new HashMap<>();
    public static void main(String[] args) throws Exception {
        try {
            BigInteger solution = BigInteger.ZERO;
            List<Long> input = Utils.readInput("resources/input.txt");

            for (Long unit : input) {
                solution = solution.add(analyzeStone(unit, 75));
            }
            
            
            System.out.println("The solution is: " + solution);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }    

    static BigInteger analyzeStone(Long stone, int iterations){
        if(iterations == 0) return BigInteger.ONE;
        Key key = new Key(stone, iterations);
        BigInteger cached = memo.get(key);
        if (cached != null) return cached;

        int next = iterations - 1;
        BigInteger res;

        if (stone == 0L) {
            res = analyzeStone(1L, next);
        } else {
            String s = Long.toString(stone);
            if ((s.length() & 1) == 0) { 
                int mid = s.length() / 2;
                long left  = Long.parseLong(s.substring(0, mid));
                long right = Long.parseLong(s.substring(mid));
                res = analyzeStone(left, next).add(analyzeStone(right, next));
            } else {
                res = analyzeStone(stone * 2024L, next);
            }
        }

        memo.put(key, res);
        return res;
        
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
