
// Matrix, Array

// create a new result matrix of result[n-2][n-2] as per given question,
// loop 1 till n - 1, and nested loop 1 till n - 1, create temp as 0, [to prevent out of bounds]
// loop i - 1 till i + 1, and nested loop j - 1 till j + 1, store max(temp, grid[k][l]) -> this way we find the max of 3x3 matrices
// then store the temp in result[i - 1][j - 1] = temp, -> i-1/j-1 because we start i and j from 1 and not 0,
// return result

package Data_Structures.Matrix.Easy;

// Optimal Solution
// Time: O(n^2), (n [i] * n [j]) * (3 [k] * 3 [l]) -> 9(n^2) -> n^2, n = grid.length
// inner for loops k and l combined, always run 9 times, so constant time
// Space: O(n^2), (n * n) [result] + n + temp, n = grid.length
class Solution {
  public int[][] largestLocal(int grid[][]) {
    int n = grid.length;

    int result[][] = new int[n - 2][n - 2];

    for (int i = 1; i < n - 1; i++) {
      for (int j = 1; j < n - 1; j++) {
        int temp = 0;

        for (int k = i - 1; k <= i + 1; k++) {
          for (int l = j - 1; l <= j + 1; l++) {
            temp = Math.max(temp, grid[k][l]);
          }
        }

        result[i - 1][j - 1] = temp;
      }
    }

    return result;
  }
}
