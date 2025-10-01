package day06;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static List<List<Character>> readInput(String path) throws IOException{
        BufferedReader br;
        List<List<Character>> output = new ArrayList<>();
        try {
            br = new BufferedReader(new FileReader(path));
            
            try {
                String line = br.readLine();
                 while (line != null) {
                    List<Character> chars = new ArrayList<Character>();
                    for (char c : line.toCharArray()) {
                        chars.add(c);
                    }
                    output.add(chars);
                    line = br.readLine();
                }
            } finally {
                br.close();
            }
                } catch (FileNotFoundException e) {

            e.printStackTrace();
        }
        return output;
    }

    public static Position findInitalPostion(List<List<Character>> matrix) throws Exception{
        for(int i =0;i<matrix.size();i++){
            for(int j =0;j<matrix.get(i).size();j++){
                if(matrix.get(i).get(j) == '^'){
                    return new Position(j,i);
                }
            }
        }
        throw new Exception("Didnt find position");
    }

    record Coordinates(int x, int y) {}
}

final class Position {
    public int x;
    public int y;
    public int next_x = 0;
    public int next_y = -1;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move(){
        this.x+=next_x;
        this.y+=next_y;
    }

    public int nextX(){
        return x+next_x;
    }

    public int nextY(){
        return y+next_y;
    }

    public void rotate(){
        if(this.next_x == 0 && this.next_y == -1){
            this.next_x = 1;
            this.next_y = 0;
        }else if(this.next_x == 1 && this.next_y == 0){
            this.next_x = 0;
            this.next_y = 1;
        }else if(this.next_x == 0 && this.next_y == 1){
            this.next_x = -1;
            this.next_y = 0;
        }else if(this.next_x == -1 && this.next_y == 0){
            this.next_x = 0;
            this.next_y = -1;
        }
    }
}
