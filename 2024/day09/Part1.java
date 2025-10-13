package day09;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Part1 {
    public static void main(String[] args) throws Exception {
        try {
            long solution = 0L;
            List<String> input = Utils.readInput("resources/input.txt");
            List<String> mappingFormated = formatIds(input);

            List<Integer> arrangedList = arrangeList(mappingFormated);            
            for (int pos = 0; pos < arrangedList.size(); pos++) {
                int id = arrangedList.get(pos);
                if (id >= 0) solution += (long) pos * id;
            }
            System.out.println("The solution is: " + solution);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    static List<String> formatIds(List<String> mappingSpace){
        List<String> idsList = new ArrayList<>();
        boolean freeSpace = false;
        int id = 0;
        String spotChar = ".";
        for(String space: mappingSpace){
            if(freeSpace){
                spotChar = ".";
            }
            else{
                spotChar =String.valueOf(id);
                id++;
            }
            freeSpace = !freeSpace;
            for(int i= 0; i< (Integer.parseInt(space));i++){
                idsList.add(spotChar);
            }
        }

        return idsList;
    }

    static List<Integer> arrangeList(List<String> mappedList){
        List<Integer> arrangedList = new ArrayList<>();
        int left = 0;
        int right = findNextChar(mappedList, mappedList.size()-1);
        while (left<right) {
            if(mappedList.get(left) == "."){
                arrangedList.add(Integer.parseInt(mappedList.get(right)));
                right--;
                left++;
                right = findNextChar(mappedList, right);
            }else{
                arrangedList.add(Integer.parseInt(mappedList.get(left)));
                left++;
            }
            
        }

        return arrangedList;        
    }
    static int findNextChar(List<String> mappedList,int pos){
        while(true){
            String charInPos = mappedList.get(pos);
            if(charInPos != "."){
                break;
            }
            pos--;
        }
        return pos;
    }
}
