
// Math, Recursion

// 1st check if n is negative, if yes then change n to positive (n = -(n)), and change x to 1/x (x = 1/x), this should fix the -n problem
// create a double var, pow and set it to 1,
// run a loop till n != 0, check if ((n & 1) != 0), if yes, then pow = pow * x, (check the n's last binary digit, if its 1 then only go inside the loop),
// set x to x * x, (square the x) (x = x * x),
// and shift the n bits to the right by 1 bit, (n = n >>> 1),
// return pow;

package Algorithms.Math.Medium;

class Solution {
  public double myPow(double x, int n) {
    if (n < 0) {
      n = -(n);
      x = 1 / x;
    }

    double pow = 1;
    while (n != 0) {
      if ((n & 1) != 0) {
        pow = pow * x;
      }

      x = x * x;
      n = n >>> 1;
    }

    return pow;
  }
}
