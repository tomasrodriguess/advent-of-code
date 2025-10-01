package day06;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;

public class Part1 {
    public static void main(String[] args) throws Exception {
        try {
            int solution = 0;
            List<List<Character>> input = Utils.readInput("resources/input.txt");

            Position initial_position = Utils.findInitalPostion(input);
            solution += countPositionsWalked(input,initial_position);

            System.out.println("The solution is: " + solution);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static int countPositionsWalked(List<List<Character>> matrix,Position position){
        HashSet<Utils.Coordinates> positionsWalked = new HashSet<Utils.Coordinates>();
        positionsWalked.add(new Utils.Coordinates(position.x,position.y));
        try{
            while(true){
                int nextX = position.nextX();
                int nextY = position.nextY();
                if (matrix.get(nextY).get(nextX) == '#'){
                    position.rotate();
                }else{
                    position.move();
                    positionsWalked.add(new Utils.Coordinates(position.x,position.y));
                }

            }
        }catch(IndexOutOfBoundsException e){
            return positionsWalked.size();
        }
    }
}

