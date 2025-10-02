package day06;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;

public class Part1 {
    public static void main(String[] args) throws Exception {
        try {
            int solution = 0;
            List<List<Character>> input = Utils.readInput("resources/input.txt");

            Guard guard = Utils.findInitalPostion(input);
            solution += countPositionsWalked(input,guard);

            System.out.println("The solution is: " + solution);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static int countPositionsWalked(List<List<Character>> matrix,Guard guard){
        HashSet<Utils.Coordinates> positionsWalked = new HashSet<Utils.Coordinates>();
        positionsWalked.add(new Utils.Coordinates(guard.x,guard.y));
        try{
            while(true){
                int nextX = guard.nextX();
                int nextY = guard.nextY();
                if (matrix.get(nextY).get(nextX) == '#'){
                    guard.rotate();
                }else{
                    guard.move();
                    positionsWalked.add(new Utils.Coordinates(guard.x,guard.y));
                }

            }
        }catch(IndexOutOfBoundsException e){
            return positionsWalked.size();
        }
    }
}

