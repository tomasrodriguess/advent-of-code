package day04;

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

    public static int findWord(List<List<Character>> matrix,String word,int pos_x, int pos_y,int mov_x, int mov_y){
        try{
            if (matrix.get(pos_x).get(pos_y)==word.charAt(0) ){
                String new_word = word.substring(1);
                if(new_word.isEmpty()) return 1;
                return findWord(matrix,new_word,pos_x+mov_x,pos_y+mov_y,mov_x,mov_y);
            }
            else{
                return 0;
            }
        }catch (IndexOutOfBoundsException e) {
            return 0;
        }        
    }
}
