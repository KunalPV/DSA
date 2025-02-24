
// Graph, BFS, Queue, Matrix, Array
//
// create rows and cols as maze.length and maze[0].length,
// create a Queue<int[]> queue, and queue.offer(entrance),
// set maze[entrance[0]][entrance[1]] = '+',
// create a int[][] directions = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}},
// create steps and store 0 and declare x, y variable,
// loop till NOT queue.ifEmpty,
// create n as queue.size(),
// loop i = 0 till n,
// create int[] current = queue.poll(),
// loop int[] direction through directions,
// set x = current[0] + direction[0] and y = current[1] + direction[1],
// check if 0 > x >= rows or 0 > y >= cols or maze[x][y] == '+', if yes continue;
// check if (x == 0 or rows - 1) or (y == 0 or cols - 1), if yes return step;
// set maze[x][y] = '+',
// queue.offer(new int[] {x, y}),
// return -1;
//
import java.util.*;

// Expected Solution: BFS using Queue
// Time: O(m * n), worst case: we visit all the cells, m = num of rows and n = num of cols
// Space: O(m * n), worst case: queue holds all cells (all cells are open), m = num of rows and n = num of cols
class Solution {

    public int nearestExit(int[][] maze, int[] entrance) {
        int rows = maze.length;
        int cols = maze[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(entrance);
        maze[entrance[0]][entrance[1]] = '+';

        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        int steps = 0;
        int x, y;
        while (!queue.isEmpty()) {
            steps++;

            int n = queue.size();
            for (int i = 0; i < n; i++) {
                int[] current = queue.poll();

                for (int[] direction : directions) {
                    x = current[0] + direction[0];
                    y = current[1] + direction[1];

                    if (x < 0 || x >= rows || y < 0 || y >= cols || maze[x][y] == '+') {
                        continue;
                    }

                    if (x == 0 || x == rows - 1 || y == 0 || y == cols - 1) {
                        return steps;
                    }

                    maze[x][y] = '+';
                    queue.offer(new int[]{x, y});
                }
            }
        }

        return -1;
    }
}
