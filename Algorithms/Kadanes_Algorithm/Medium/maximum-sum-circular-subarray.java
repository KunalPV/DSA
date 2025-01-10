
// Array, Divide and Conquer, Dynamic Programming, Queue, Monotonic Queue

// create variable maxSum, minSum and assign 1st elem from nums, and create currMax, currMin and totalSum and assign 0.
// loop through nums, set the currMax to max of (currMax + nums[i]) or nums[i], and set currMin to min of (currMin + nums[i]) or nums[i]. Then set maxSum to max of currMax or maxSum and set minSum to min of currMin or minSum. And finally set totalSum to totalSum + nums[i]
// if maxSum > 0 then return max of maxSum or totalSum - minSum, else return just maxSum.

// ** idea here in kadane's algorithm is, for maximum subarray, when we find the max subarray. The array elements left other than the max subarray is the min subarray.
// ** as we have to find a circular subarray, if we just find the min subarray, the rest of the elements are considered to be max subarray.

package Algorithms.Kadanes_Algorithm.Medium;

class Solution {
  public int maxSubarraySumCircular(int[] nums) {
    int maxSum = nums[0], minSum = nums[0], currMax = 0, currMin = 0;
    int totalSum = 0;

    for (int num : nums) {
      currMax = Math.max(currMax + num, num);
      maxSum = Math.max(currMax, maxSum);
      currMin = Math.min(currMin + num, num);
      minSum = Math.min(currMin, minSum);
      totalSum += num;
    }

    return maxSum > 0 ? Math.max(maxSum, totalSum - minSum) : maxSum;
  }
}
