
// Array, Bit Manipulation

// create a var result as 0, loop through the given array, set result = result ^ num/nums[i], and return result;

// ^ XOR, cancels out the same element,
// ex: [4, 1, 2, 1, 2] => result = 4 ^ 1 ^ 2 ^ 1 ^ 2 => result = 4,
// 1 ^ 1 and 2 ^ 2, cancels out each other.

package Algorithms.Bit_Manipulation.Easy;

class Solution {
  public int singleNumber(int[] nums) {
    int result = 0;

    for (int num : nums) {
      result = result ^ num;
    }

    return result;
  }
}
