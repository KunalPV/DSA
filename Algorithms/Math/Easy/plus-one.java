
// Array, Math

// run a loop from digits.length - 1 till 0, check if the digits[i] < 9, increment digits[i] by 1 and return the digits,
// if not then that means the digit is 9, set the digits[i] = 0,
// if we didnt return the digits by now, that means the digits given is [9] or [9, 9] and so on,
// create a newNum array with n + 1 size, add the 1st elem as 1 => [1, 0] or [1, 0, 0] and so on,
// return newNum;

package Algorithms.Math.Easy;

class Solution {
  public int[] plusOne(int[] digits) {
    int n = digits.length;

    for (int i = n - 1; i >= 0; i--) {
      if (digits[i] < 9) {
        digits[i]++;
        return digits;
      }

      digits[i] = 0;
    }

    int newNum[] = new int[n + 1];
    newNum[0] = 1;

    return newNum;
  }
}
