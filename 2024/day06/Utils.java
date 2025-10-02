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

    public static Guard findInitalPostion(List<List<Character>> matrix) throws Exception{
        for(int i =0;i<matrix.size();i++){
            for(int j =0;j<matrix.get(i).size();j++){
                if(matrix.get(i).get(j) == '^'){
                    return new Guard(j,i, 'N');
                }
            }
        }
        throw new Exception("Didnt find position");
    }

    record Coordinates(int x, int y) {}

    record CoordinatesAndDirection(int x, int y, char direction) {}
}

final class Guard{
    public int x;
    public int y;
    public char direction;

    public Guard(int x, int y, char direction){
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void rotate(){
        if(this.direction == 'N'){
            this.direction = 'E';
        }else if(this.direction == 'E'){
            this.direction = 'S';
        }else if(this.direction == 'S'){
            this.direction = 'W';
        }else if(this.direction == 'W'){
            this.direction = 'N';
        }
    }
    public int nextX(){
        if(this.direction == 'W'){
            return this.x-1;
        }else if(this.direction == 'E'){
            return this.x+1;
        }
        return this.x;
    }

    public int nextY(){
        if(this.direction == 'N'){
            return this.y-1;
        }else if(this.direction == 'S'){
            return this.y+1;
        }
        return this.y;
    }

    public void move(){
        if(this.direction == 'N'){
            this.y -=1;
        }else if(this.direction == 'E'){
            this.x+=1;
        }else if(this.direction == 'S'){
            this.y +=1;
        }else if(this.direction == 'W'){
            this.x-=1;
        }
    }

}
