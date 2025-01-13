
//Divide and Conquer, Bit Manipulation

// create a variable ones and assign it with 0,
// loop till n != 0, set ones with ones + (n & 1), [n & 1, gives output of last digit of n, 1 ? 1 : 0],
// shift n to right side by 1 bit, n = n >>> 1 [unsigned shift - fills left side with 0's]
// return ones;

package Algorithms.Bit_Manipulation.Easy;

class Solution {
  public int hammingWeight(int n) {
    int ones = 0;

    while (n != 0) {
      ones = ones + (n & 1);
      n = n >>> 1;
    }

    return ones;
  }
}
