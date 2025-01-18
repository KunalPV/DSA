
// Array

// Solution1:
// loop through array and calculate prices[j] - prices[i] and store it to max var if its greater than max.
// return max;
// Note that from left to right, its days, so i should always be less than j

// Solution2:
// create 2 var, minSoFar = prices[0] and res = 0,
// loop till n, get min = min(minSoFar, prices[0]) and res = max(res, prices[i] - minSoFar)
// return res;

package Data_Structures.Array.Easy;

// Brute force, all combinations
// Time: O(n ^ 2), i = 0 to n and j = 1 to n
// Space: O(1), O(max) + O(n), constant space
class Solution1 {
  public int maximumProfit(int prices[]) {
    int max = 0, n = prices.length;

    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        max = Math.max(max, (prices[j] - prices[i]));
      }
    }

    return max;
  }
}

// Optimized Approach
// Time: O(n), max n iterations
// Space: O(1), O(n) + O(minSoFar) + o(result), constant time
class Solution2 {
  public int maximumProfit(int prices[]) {
    int n = prices.length;
    int minSoFar = prices[0], result = 0;

    for (int i = 0; i < n; i++) {
      minSoFar = Math.min(minSoFar, prices[i]);

      result = Math.max(result, prices[i] - minSoFar);
    }

    return result;
  }
}