package day08;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Part2 {
    
    record Point(int x, int y){}
    public static void main(String[] args) throws Exception {
        try {
            int solution = 0;
            // List<List<Character>> input = Utils.readInput("resources/input.txt");
            List<List<Character>> input = Utils.readInput("C:\\Users\\tomas\\Desktop\\Personal\\advent-of-code\\2024\\day08\\resources\\input.txt");
            int H = input.size();
            int W = input.get(0).size();
            Map<Character, List<Point>> antenas = findAntenas(input);

            Set<Point> antiNodesLocations = new HashSet<>();
            for (Map.Entry<Character, List<Point>> entry : antenas.entrySet()) {
                antiNodesLocations.addAll(findAntiNodes(entry.getValue(), W, H));
            }


            solution += antiNodesLocations.size();
            System.out.println("The solution is: " + solution);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<Character, List<Point>> findAntenas(List<List<Character>> matrix){
        Map<Character, List<Point>> antenas = new HashMap<>();
        for(int i = 0; i<matrix.size();i++){
            for(int j = 0; j<matrix.get(i).size();j++){
                Character positionCharacter= matrix.get(i).get(j);
                List<Point> pointsOfFrequency = antenas.get(positionCharacter);
                if(positionCharacter =='.') continue;

                if (pointsOfFrequency != null) {
                    pointsOfFrequency.add(new Point(j,i));
                    antenas.put(positionCharacter,pointsOfFrequency);
                } else {
                    antenas.put(positionCharacter,new ArrayList<>(Arrays.asList(new Point(j,i))));
                }
            }
        }
        return antenas;
    }

    public static Set<Point> findAntiNodes(List<Point> points, int W,int H){
        Set<Point> antiNodesLocations = new HashSet<>();
        if (points.size() >= 2) {
            antiNodesLocations.addAll(points);
        }
        for(int i = 0; i<points.size();i++){
            for(int j = i + 1; j<points.size();j++){
                Point pi = points.get(i), pj = points.get(j);
                int dx = pj.x - pi.x;
                int dy = pj.y - pi.y;

                int gcd = gcd(dx,dy);
                dx = dx/gcd;
                dy = dy/gcd;
                
                antiNodesLocations.addAll(findInLineAntiNodes(pi,dx,dy,W,H));
                antiNodesLocations.addAll(findInLineAntiNodes(pi,-dx,-dy,W,H));


                // Point p1 = new Point(pi.x - dx, pi.y - dy);
                // Point p2 = new Point(pj.x + dx, pj.y + dy);

                // if (inside(p1, W, H)) antiNodesLocations.add(p1);
                // if (inside(p2, W, H)) antiNodesLocations.add(p2);
            }
        }
        return antiNodesLocations;
        
    }

    static Set<Point> findInLineAntiNodes(Point currentPoint, int dx, int dy, int W, int H){
        Set<Point> antiNodesLocations = new HashSet<>();
        while (true) {
            Point point = new Point(currentPoint.x + dx, currentPoint.y + dy);
            if(!inside(point, W, H)){
                break;
            }else{
                antiNodesLocations.add(point);
                currentPoint = point;
            }
        }
        return antiNodesLocations;
    }

    static boolean inside(Point p, int W, int H) {
        return 0 <= p.x && p.x < W && 0 <= p.y && p.y < H;
    }

    static int gcd(int a, int b) {
        return BigInteger.valueOf(a).gcd(BigInteger.valueOf(b)).intValue();
    }
}
