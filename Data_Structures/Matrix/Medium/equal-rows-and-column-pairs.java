
// Array, Matrix, HashMap

// loop grid, convert arr[] to string and store in s, map.put(s, map.getOrDefault(s, 0) + 1);
// create pairs, loop 0 till n, create a temp array with n length, loop 0 till n,
// store grid[j][i] in temp[j],
// convert temp[] to string and store in s, assign pairs + map.getOrDefault(s, 0) to pairs,
// return pairs;

package Data_Structures.Matrix.Medium;

import java.util.*;

// Optimal Solution
// Time: O(n^2), nested loops -> n * n, n = grid.length
// Space: O(n), n [map] + n [temp] + 2n [String s] -> n, n = num of rows
class Solution {
  public int equalPairs(int grid[][]) {
    int n = grid.length;

    Map<String, Integer> map = new HashMap<>();

    for (int arr[] : grid) {
      String s = Arrays.toString(arr);
      map.put(s, map.getOrDefault(s, 0) + 1);
    }

    int pairs = 0;
    for (int i = 0; i < n; i++) {
      int temp[] = new int[n];
      for (int j = 0; j < n; j++) {
        temp[j] = grid[j][i];
      }

      String s = Arrays.toString(temp);
      pairs += map.getOrDefault(s, 0);
    }

    return pairs;
  }
}
