
// Matrix, Array

// create max as 0, loop 0 till rows,
// create tempMax as 0, loop 0 till cols,
// store temp + accounts[i][j] to temp,
// check if tempMax > max, if yes then max = tempMax, [can also use Math.max method]
// return max

package Data_Structures.Matrix.Easy;

// Optimal Solution: We assume rows == cols, if not then use (j < accounts[i].length) inside i loop instead of just (j < cols)
// Time: O(m * n), m [rows] * n [cols], m = accounts.length and n = accounts[0].length
// Space: O(1), max + tempMax, constant space
class Solution {
  public int maximumWealth(int accounts[][]) {
    int rows = accounts.length;
    int cols = accounts[0].length;

    int max = 0;

    for (int i = 0; i < rows; i++) {
      int tempMax = 0;

      for (int j = 0; j < cols; j++) {
        tempMax += accounts[i][j];
      }

      if (tempMax > max) {
        max = tempMax;
      }
    }

    return max;
  }
}
