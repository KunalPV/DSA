
// Array, Divide and Conquer, Dynamic Programming

// Solution 1
// create a max and sum variable with Integer.MIN_VALUE(or nums[0]) and 0, run a loop from 0 till nums.length - 1, update sum to sum + nums[i]
// update math to Math.max(sum, max) or if we dont want to check on all iterations then check if sum > max, if yes then only update max to max = sum, finally check if sum < 0, if yes then set sum = 0. and return max at the end.

// Solution 2
// follow same procedure as Solution 1, but declare new variable start, end, and s and assign all with 0. start and end will be final positions of the max subarray, s will be the temporary start index.
// int loop (0 -> nums.length - 1), sum = sum + nums[i], after that if (sum > max) then update max = sum, start = s and e = i.
// and if(sum < 0), then update sum = 0 and s = i + 1. finally return {start, end} or the whole subarray depending on the question asked

package Algorithms.Kadanes_Algorithm.Medium;

class Solution1 {
  // Maximum sum from the subarray of the given array
  public int maxSubArray(int[] nums) {
    int n = nums.length;
    int max = Integer.MIN_VALUE, sum = 0;

    for (int i = 0; i < n; i++) {
      sum += nums[i];

      // max = Math.max(max, sum);
      if (sum > max) { // saves a bit of time by not executing on all loop case
        max = sum;
      }

      if (sum < 0) {
        sum = 0;
      }
    }

    return max;
  }
}

class Solution2 {
  // Return or Print start and end position of subarray, or the whole subarray
  // itself.
  @SuppressWarnings("unused")
  public int maxSubArray(int[] nums) {
    int n = nums.length;
    int max = Integer.MIN_VALUE, sum = 0;
    int start = 0, end = 0; // final position of the subarray
    int s = 0; // temporary start index

    for (int i = 0; i < n; i++) {
      sum += nums[i];

      if (sum > max) {
        max = sum;
        start = s;
        end = i;
      }

      if (sum < 0) {
        sum = 0;
        s = i + 1;
      }
    }

    // return new int[] {start, end}
    // return new int[] {nums[start], ... , nums[end]}
    return max;
  }
}
