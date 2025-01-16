
// Math

// create a var numZeros as 0 to count the number of zeros left at the end.
// Here the number of zeros at the end of factorial number of n depends on n.
// for 1 - 4 -> no zeros, 5 - 9 -> 1 zero, 10 - 14 -> 2 zeros... but at 25 its 6 zeros instead of 5 zeros

// by that logic, run a loop till n > 0, divide n by 5 (n /= 5), and store this value into the numZeros variable (numZeros += n),
// return numZeros;

// 3 => n = 3 / 5 => numZeros = 0 + 0 => 0 (no zeros at the end of factorial)
// 7 => n = 5 / 5 => numZeros = 0 + 1 => 1 (1 zero)
// 25 => n = 25 / 5 => numZeros = 0 + 5 => n = 5 / 5 => numZeros = 5 + 1 => 6 (6 zeroes)

package Algorithms.Math.Medium;

class Solution {
  public int trailingZeroes(int n) {
    int numZeros = 0;

    while (n > 0) {
      n = n / 5;
      numZeros = numZeros + n;
    }

    return numZeros;
  }
}
