
// Matrix, Array

// create res as 0, 
// loop 0 till n, add res + matrix[i][i] to res, [added up-left -> down-right side]
// and add res + matrix[n-1-i][i] to res, [added down-left -> up-right side]
// ** check if n is even, if yes return, else that means we added the mid elem of matrix twice to the res, so remove it and return
// return n % 2 == 0 ? res : res - matrix[n / 2][n / 2];

package Data_Structures.Matrix.Easy;

// Optimal Solution
// Time: O(n), n = matrix.length
// each diagonal elem is visited once [except if n == odd, then mid elem of matrix is visited twice, but doesn't matter]
// Space: O(1), n + res [Auxillary space], constant time
class Solution {
  public int diagonalSum(int matrix[][]) {
    int n = matrix.length;
    int res = 0;

    for (int i = 0; i < n; i++) {
      res += matrix[i][i];
      res += matrix[n - 1 - i][i];
    }

    return n % 2 == 0 ? res : res - matrix[n / 2][n / 2];
  }
}
