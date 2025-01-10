
// Array, Binary Search, Matrix

// treat 2D array (matrix) as 1D array.
// calculate rows and cols and create var left and right as 0 and rows * cols - 1, run a loop till left <= right
// calculate the mid of the matrix by left + ((right - left) / 2), and find mid_val by matrix[mid / cols][mid % cols]
// if mid_val equals target, then return true, else if its less than target, then left = mid + 1, else right = mid - 1
// return false at the end, if the element doesnt exist.

package Algorithms.Searching.Binary_Search.Medium;

class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    int rows = matrix.length;
    int cols = matrix[0].length;
    int left = 0, right = rows * cols - 1;

    while (left <= right) {
      int mid = left + ((right - left) / 2);
      int mid_val = matrix[mid / cols][mid % cols];

      if (mid_val == target) {
        return true;
      } else if (mid_val < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return false;
  }
}
