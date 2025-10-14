package day09;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Part2 {
    public static void main(String[] args) throws Exception {
        try {
            long solution = 0L;
            List<String> input = Utils.readInput("resources/input.txt");

            List<String> mappingFormated = formatIds(input);
            
            Map<Integer,Integer> freeSpaces = getFreeSpaces(mappingFormated);
            
            List<String> arrangedList = arrangeListWithFreeSpaces(mappingFormated,freeSpaces);
            // System.err.println(arrangedList);
            // List<Integer> arrangedList = arrangeList(mappingFormated);            
            for (int pos = 0; pos < arrangedList.size(); pos++) {
                String idStr = arrangedList.get(pos);
                if(idStr.equals(".")) continue;
                int id = Integer.parseInt(idStr);
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

    static Map<Integer,Integer> getFreeSpaces(List<String> mappingFormated){
        Map<Integer,Integer> freeSpace = new TreeMap<>();
        int i = 0;
        boolean free = false;
        int index = 0;
        while(i < mappingFormated.size()){
            if(mappingFormated.get(i).equals(".")){
                if(!free){
                    index =i;
                    free= true;
                }
            }else{
                if(free){
                    freeSpace.put(index,i-index);
                    free= false;
                }
            }
            i++;
        }

        return freeSpace;
    }

    static List<String> arrangeListWithFreeSpaces(List<String> mappingFormated, Map<Integer,Integer> freeSpaces){
        int i = mappingFormated.size()-1;
        while(i > 0){
            String element = mappingFormated.get(i);
            if(element.equals(".")){
                i--;
                continue;
            }else if(element.equals("0")) break;

            int size = findElementSpace(mappingFormated, i);
            
            // insertInBegginingOfList(mappingFormated,size,freeSpaces,mappingFormated.get(i));//run freespaces from beggning when slot availbale insert int the begin and remove from the end, update fresspaces also
            for (Map.Entry<Integer, Integer> entry : freeSpaces.entrySet()) {
                Integer key = entry.getKey();
                Integer slots = entry.getValue();
                if(key>i) break;
                if(size <= slots){
                    for(int j=key;j<key+size;j++){
                        mappingFormated.set(j,element);
                    }
                    for(int j=i-size+1;j<i+1;j++){
                        mappingFormated.set(j,".");
                    }
                    int remainingSlots = slots-size;
                    if(remainingSlots > 0){
                        freeSpaces.put((key+size),remainingSlots);
                    }
                    freeSpaces.remove(key);
                    break;
                }


            }
            
            
            i-=size;
        }

        return mappingFormated;
    } 
    static int findElementSpace(List<String>mappingFormated, int i){
        String element = mappingFormated.get(i);
        int size = 0;
        int k = i;
        while (k >= 0 && mappingFormated.get(k).equals(element)) {
            size++;
            k--;
        }
        return size;
    }
}
