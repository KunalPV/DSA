
// Divide and Conquer, Bit Manipulation

// Solution1 (O(n) time)
// create a var result with 0, loop 32 times (0 to 32 bit), move result to left by 1 bit,
// check if (n & 1) == 1, is yes then result++, then move n to right by 1 bit. return result.

// Solution2 (O(logn) time)
// virtually divide the 32 bits into 2 parts, move 1st part to right and 2nd part to left. ((n & 0xffff0000) >>> 16) | ((n & 0x0000ffff) << 16)
// next divide it into 4 parts and interchange 1st 2 parts with each other and next 2 parts to with each other, ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8),
// next ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4),
// next ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2), [c = 1100, 3 = 0011]
// next ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1), [a = 1010, 5 = 0101]
// return n, [we move 1st half to right by >>> which preserves the order by putting 0's in the 1st half]

package Algorithms.Bit_Manipulation.Easy;

class Solution1 {
  public int reverseBits(int n) {
    if (n == 0)
      return 0;

    int result = 0;
    for (int i = 0; i < 32; i++) {
      result = result << 1;
      if ((n & 1) == 1) {
        result++;
      }
      n = n >> 1;
    }

    return result;
  }
}

class Solution2 {
  public int reverseBits(int n) {

    n = ((n & 0xffff0000) >>> 16) | ((n & 0x0000ffff) << 16);
    n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);
    n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);
    n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);
    n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);

    return n;
  }
}
