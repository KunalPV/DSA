
// Array, Matrix, Graph, BFS, Queue
//
// create rows and cols as grid.length and grid[0].length,
// create a Queue<int[]> queue, and count_fresh as 0,
// loop i = 0 till rows, and loop j = 0 till cols, 
// check if grid[i][j] == 2, if yes queue.offer(new int[] {i, j}),
// else if grid[i][j] == 1, if yes count_fresh++;
// check if count_fresh == 0, return 0;
// create a int directions[][] = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}},
// create count as 0, and just declare x and y,
// loop till NOT queue.isEmpty,
// increment count by 1 and create n as queue.size(),
// loop i = 0 till n, create int[] current = queue.poll(),
// loop int[] direction through directions,
// set x = current[0] + direction[0] and y = current[1] + direction[1],
// check if 0 > x >= rows or 0 > y >= cols or grid[x][y] == (0 or 2), continue;
// set the grid[x][y] = 2,
// queue.offer(new int[] {x, y}),
// decrement count_fresh by 1,
// return (count_fresh == 0) ? count - 1 : -1;
//
import java.util.*;

// Expected Solution: BFS using Queue
// Time: O(m * n), worst case: 1 rotten orange and all fresh ones, m = num of rows and n = num of cols
// Space: O(m * n), worst case: all oranges are rotten oranges, m = num of rows and n = num of cols
class Solution {

    public int rottenOranges(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int count_fresh = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    count_fresh++;
                }
            }
        }

        if (count_fresh == 0) {
            return 0;
        }

        int directions[][] = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        int x, y;
        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            int n = queue.size();

            for (int i = 0; i < n; i++) {
                int[] current = queue.poll();

                for (int[] direction : directions) {
                    x = current[0] + direction[0];
                    y = current[1] + direction[1];

                    if (x < 0 || x >= rows || y < 0 || y >= cols || grid[x][y] == 0 || grid[x][y] == 2) {
                        continue;
                    }

                    grid[x][y] = 2;
                    queue.offer(new int[]{x, y});
                    count_fresh--;
                }
            }
        }

        return (count_fresh == 0) ? count - 1 : -1;
    }
}
