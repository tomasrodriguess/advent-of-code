package day02;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {
    public static List<List<Integer>> readInput(String path) throws IOException{
        BufferedReader br;
        List<List<Integer>> output =new ArrayList<List<Integer>>();
        try {
            br = new BufferedReader(new FileReader(path));

            try {
                String line = br.readLine();

                while (line != null) {
                    List<Integer> inputs =Arrays.asList(line.split(" ")).stream().map(s -> Integer.parseInt(s.trim())).collect(Collectors.toList());
                    output.add(inputs);
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

    public static boolean isSafeReport(List<Integer> report, boolean retry){

        boolean increasing = report.get(0) < report.get(1);
        int distance = Math.abs(report.get(0) - report.get(1));
        int starting_index = 2;
        if(distance > 3 || distance == 0){
                if(retry){
                    return retryReport(report);
                }else{
                    return false;
                }
        }
        int reportSize = report.size();
        for(int i=starting_index;i < reportSize;i++){
            int current = report.get(i) - report.get(i-1);
            distance = Math.abs(current);
            if((distance > 3) || (increasing && current<=0) || (!increasing && current>=0)){
                if(retry){
                    return retryReport(report);
                }else{
                    return false;
                }
                
            }
        }
        return true;
    }

    public static boolean retryReport(List<Integer> report){
        int reportSize = report.size();
        for(int i=0;i < reportSize;i++){
            List<Integer> newReport = new ArrayList<>(report);
            newReport.remove(i);
            if( isSafeReport(newReport,false)){
                return true;
            }
        }
        return false;
    }

    public static boolean isSafeReportWithRetry(List<Integer> report){
        boolean increasing = report.get(0) < report.get(1);
        int distance = Math.abs(report.get(0) - report.get(1));
        if(distance > 3 || distance == 0){
                return false;
            }
        for( int i =2;i < report.size();i++){
            int current = report.get(i) - report.get(i-1);
            distance = Math.abs(current);
            if((distance > 3) || (increasing && current<=0) || (!increasing && current>=0)){
                return false;
            }
        }
        return true;
    }
}
