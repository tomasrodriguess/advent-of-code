package day10;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Part2 {
        public record Point(int x, int y){}
    public static void main(String[] args) throws Exception {
        try {
            int solution = 0;
            List<List<Integer>> input = Utils.readInput("resources/input.txt");


            int H = input.size();
            int W = input.get(0).size();
            List<Point> startingPoints = findStartingpoints(input);
            
            for(Point point:startingPoints){
                solution += findGoodHikingTrails(input, point,H,W,0);           
            }
            
            System.out.println("The solution is: " + solution);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static List<Point> findStartingpoints(List<List<Integer>> matrix){
        List<Point> startingPoints = new ArrayList<>();
        for(int i = 0; i< matrix.size();i++){
            for(int j = 0; j< matrix.get(i).size();j++){
                if(matrix.get(i).get(j) == 0){
                    startingPoints.add(new Point(j, i));
                }
            }
        }
        return startingPoints;
    }

    static int findGoodHikingTrails(List<List<Integer>> matrix, Point point,int H, int W, int height){
        if (height == 9) { 
            return 1;
        }

        int nh = height + 1;
        int count = 0;

        if (inside(point.x, point.y - 1, W, H) && matrix.get(point.y - 1).get(point.x) == nh)
            count += findGoodHikingTrails(matrix, new Point(point.x, point.y - 1),  H, W,nh);


        if (inside(point.x, point.y + 1, W, H) && matrix.get(point.y + 1).get(point.x) == nh)
            count += findGoodHikingTrails(matrix, new Point(point.x, point.y + 1), H, W, nh);


        if (inside(point.x - 1, point.y, W, H) && matrix.get(point.y).get(point.x - 1) == nh)
            count += findGoodHikingTrails(matrix, new Point(point.x - 1, point.y), H, W, nh);


        if (inside(point.x + 1, point.y, W, H) && matrix.get(point.y).get(point.x + 1) == nh)
            count += findGoodHikingTrails(matrix, new Point(point.x + 1, point.y), H, W, nh);
        return count;
    }

    static boolean inside(int x, int y, int W, int H) {
        return 0 <= x && x < W && 0 <= y && y < H;
    }
}
