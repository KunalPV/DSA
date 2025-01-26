
// Array, Sliding Window

// create minDiff as IntMaxVal, then sort the given array or List,
// run a loop 0 till (i + m - 1) < n, calculate the diff between nums[i + m - 1] and nums[i]
// check if diff < minDiff, if yes then set minDiff = diff,
// return minDiff

package Data_Structures.Array.Easy;

import java.util.*;

// Optimal Solution
// Time: O(n logn), n [loop]+ n logn [sort], n = nums.length
// Space: O(1), minDiff + diff + i, constant time
class Solution {
  public int findMinDiff(ArrayList<Integer> nums, int m) {
    int n = nums.size();
    int minDiff = Integer.MAX_VALUE;

    Collections.sort(nums);

    for (int i = 0; i + m - 1 < n; i++) {
      int diff = nums.get(i + m - 1) - nums.get(i);

      if (diff < minDiff) {
        minDiff = diff;
      }
    }
    return minDiff;
  }
}
