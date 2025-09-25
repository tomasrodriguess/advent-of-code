package day04;

import java.io.IOException;
import java.util.List;

public class Part2 {
     public static void main(String[] args) {
        try {
            int solution = 0;
            List<List<Character>> input = Utils.readInput("resources/input.txt");


            for (int i = 0; i < input.size(); i++){
                for (int j = 0; j < input.get(i).size(); j++){
                    if(input.get(i).get(j) =='A'){
                        if(isXCenter(input, i,j)) solution++;
                    }
                }
            }
            System.out.println("The solution is: " + solution);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isXCenter(List<List<Character>> matrix, int x, int y){
        try{
            Character upper_left = matrix.get(x-1).get(y-1);
            Character bottom_left = matrix.get(x-1).get(y+1);
            Character bottom_right = matrix.get(x+1).get(y+1);
            Character upper_right = matrix.get(x+1).get(y-1);
            if(
                upper_left == upper_right
                &&
                bottom_left == bottom_right
                &&
                (
                    (upper_left == 'M' && bottom_left == 'S')
                    ||
                    (upper_left == 'S' && bottom_left == 'M')
                )
            ){  
                return true;
            }else if(
                upper_left == bottom_left
                &&
                upper_right == bottom_right
                &&
                (
                    (upper_left == 'M' && upper_right == 'S')
                    ||
                    (upper_left == 'S' && upper_right == 'M')
                )
            ){
                return true;
            }
        }catch(IndexOutOfBoundsException e){
            return false;
        }
        System.out.println("no");
        return false;
    }
}
