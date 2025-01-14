
// Array, Bit Manipulation

// create an ans variable as 0, run a loop from 0 to 32 iteration, create a var sum as 0,
// inside this run a loop again from 0 till nums.length, add sum + (nums[i] >> i & 1) to the sum,
// come out of the inside loop, then mod the sum by 3, sum = sum % 3, this gives 1 if bits are more than 3 or 0 if the bits are less than or equal to 3,
// add this sum to the ith bit of the ans, ans = ans | (sum << i)
// return ans;

// Time Complexity here is O(32 * n) -> O(n) [Linear Time Complexity].

package Algorithms.Bit_Manipulation.Medium;

class Solution {
  public int singleNumber(int[] nums) {
    int ans = 0;

    for (int i = 0; i < 32; ++i) {
      int sum = 0;

      for (int num : nums) {
        sum = sum + (num >> i & 1);
      }

      sum = sum % 3;

      ans = ans | (sum << i);
    }

    return ans;
  }
}
