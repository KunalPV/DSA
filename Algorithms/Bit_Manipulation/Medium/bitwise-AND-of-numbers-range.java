
// Bit Manipulation

// create a counter variable count as 0, then run a loop till left != right,
// in the loop, shift the bit to left side by 1 of both left and right variable on each iteration, and increment the count variable by 1 each time this happens,
// at the end return (left << count), which gives the ans of all the AND of numbers in that range.

// Time complexity: O(1), where the max range the while loop can run is 31 as there exists 32 bit integer.

package Algorithms.Bit_Manipulation.Medium;

class Solution {
  public int rangeBitwiseAnd(int left, int right) {
    int count = 0;

    while (left != right) {
      left = left >> 1;
      right = right >> 1;
      count++;
    }

    return (left << count);
  }
}
