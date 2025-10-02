package day06;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;

public class Part2 {
        public static void main(String[] args) throws Exception {
        try {
            int solution = 0;
            List<List<Character>> input = Utils.readInput("resources/input.txt");


            Guard guard = Utils.findInitalPostion(input);

            // Run across all positions
            for (int y = 0; y < input.size(); y++) {
                for (int x = 0; x < input.get(0).size(); x++) {
                    if (input.get(y).get(x) != '.') continue;
                    if (x == guard.x && y == guard.y) continue;

                    // place temporary blocker
                    char prev = input.get(y).get(x);
                    input.get(y).set(x, '#');
                    if (simulatesToLoop(input, guard)) solution++;
                    // revert
                    input.get(y).set(x, prev);
                }
            }

            System.out.println("The solution is: " + solution);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static boolean simulatesToLoop(List<List<Character>> matrix, Guard guard) {
        Guard new_guard = new Guard(guard.x, guard.y, guard.direction);
        HashSet<Utils.CoordinatesAndDirection> visited = new HashSet<>();

        try {
            while (true) {
                Utils.CoordinatesAndDirection st =  new Utils.CoordinatesAndDirection(new_guard.x, new_guard.y, new_guard.direction);
                if (!visited.add(st)) return true; 

                int next_x = new_guard.nextX();
                int next_y = new_guard.nextY();
                if (matrix.get(next_y).get(next_x) == '#') {
                    new_guard.rotate();
                } else {
                    new_guard.move();
                }
            }
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }
}

