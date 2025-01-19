
// Array, Kadane's Algorithm

// create currMin, currMax and maxVal variables,
// loop till n, create and set temp as max of nums[i], nums[i] * currMax, nums[i] * currMin,
// update currMin to min of nums[i], nums[i] * currMax, nums[i] * currMin /// this is done to keep track of 2 negative numbers one after the other
// update currMax as currMax = temp,
// update maxVal as maxVal = max of maxVal, currMax
// return maxVal;

package Algorithms.Kadanes_Algorithm.Medium;

// Returns only the maximum the product from the given array
// Time: O(n), n = nums.length
// Space: O(1), currMin + currMax + maxVal = 1, constant space
class Solution {
  public int maxProduct(int nums[]) {
    int n = nums.length;
    int currMin = nums[0], currMax = nums[0], maxVal = nums[0];

    for (int i = 1; i < n; i++) {
      int temp = max(nums[i], nums[i] * currMax, nums[i] * currMin);

      currMin = min(nums[i], nums[i] * currMax, nums[i] * currMax);

      currMax = temp;

      maxVal = Math.max(maxVal, currMax);
    }

    return maxVal;
  }

  private int max(int a, int b, int c) {
    return Math.max(a, Math.max(b, c));
  }

  private int min(int a, int b, int c) {
    return Math.min(a, Math.min(b, c));
  }
}
