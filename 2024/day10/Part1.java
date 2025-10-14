package day10;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Part1 {
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
        Set<Point> peaks = new HashSet<>();
        expandPath(matrix, point, height, H, W, peaks);
        return peaks.size();
    }

    static void expandPath(List<List<Integer>> matrix, Point p, int h, int H, int W, Set<Point> peaks) {

        if (matrix.get(p.y).get(p.x) != h) return;

        if (h == 9) {              
            peaks.add(p);     
            return;
        }

        int nh = h + 1;


        if (inside(p.x, p.y - 1, W, H) && matrix.get(p.y - 1).get(p.x) == nh)
            expandPath(matrix, new Point(p.x, p.y - 1), nh, H, W, peaks);


        if (inside(p.x, p.y + 1, W, H) && matrix.get(p.y + 1).get(p.x) == nh)
            expandPath(matrix, new Point(p.x, p.y + 1), nh, H, W, peaks);


        if (inside(p.x - 1, p.y, W, H) && matrix.get(p.y).get(p.x - 1) == nh)
            expandPath(matrix, new Point(p.x - 1, p.y), nh, H, W, peaks);


        if (inside(p.x + 1, p.y, W, H) && matrix.get(p.y).get(p.x + 1) == nh)
            expandPath(matrix, new Point(p.x + 1, p.y), nh, H, W, peaks);
    }


    static boolean inside(int x, int y, int W, int H) {
        return 0 <= x && x < W && 0 <= y && y < H;
    }
}

