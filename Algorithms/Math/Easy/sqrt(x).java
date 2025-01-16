
// Math, Binary Search

// return x if x equals 0 or 1 because sqrt(0 or 1) is the num itself,
// take 2 variables left and right as 0 and x, and run a loop till left <= right,
// calculate the mid, then check if the mid * mid > x, that means the possible sqrt(x) lies on the left side of the mid, right = mid - 1;
// if mid * mid == x, that means we have a num x which has a integer sqrt(4, 9, 16, 25, 36, ...), return mid, 
// if mid * mid < x, then the sqrt(x) lies on the right side of the mid, left = mid + 1;
// if we come out of loop that means x is not a floating sqrt(3, 5, 6, 7, 8, 10, ...), if this happens then right will be at the possible solution, return Math.square(right) (floor function)

package Algorithms.Math.Easy;

class Solution {
  public int mySqrt(int x) {
    if (x == 0 || x == 1) {
      return x;
    }

    int left = 0, right = x;
    while (left <= right) {
      int mid = left + ((right - left) / 2);

      if ((long) mid * mid > (long) x) {
        right = mid - 1;
      } else if (mid * mid == x) {
        return mid;
      } else {
        left = mid + 1;
      }
    }

    return Math.round(right);
  }
}
