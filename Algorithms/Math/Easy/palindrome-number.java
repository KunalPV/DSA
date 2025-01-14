
// Math

// Solution1
// create a reversed var as 0, and temp and set it to the given num x, (make it a long to not overflow)
// loop till temp != 0, (int) temp % 10 gives the unit place digit and store it in int digit variable,
// add the reversed * 10 and digit and store it in reversed, then divide the temp by 10
// return x == reversed;

// Solution2
// create reversed variable and set it to 0, loop till x > reversed, 
// take the digit from the x by digit = x % 10, then add it to reversed, reversed = reversed * 10 + digit,
// divide x / 10, and store it in x,
// finally return (x == reversed) [even num] || (x == reversed / 10) [odd num]

package Algorithms.Math.Easy;

// Reverse the number and compare it with the original
class Solution1 {
  public boolean isPalindrome(int x) {
    if (x < 0)
      return false;

    long reversed = 0;
    long temp = x;

    while (temp != 0) {
      int digit = (int) (temp % 10);
      reversed = reversed * 10 + digit;
      temp = temp / 10;
    }

    return x == reversed;
  }
}

// Reverse just the 2nd half of the number and compare it with the 1st half,
// for even num: 1st half == 2nd half || for odd num: 1st half == 2nd half / 10
class Solution2 {
  public boolean isPalindrome(int x) {
    if (x < 0 || (x != 0 && x % 10 == 0)) {
      return false;
    }

    int reversed = 0;

    while (x > reversed) {
      int digit = x % 10;
      reversed = reversed * 10 + digit;
      x = x / 10;
    }

    return (x == reversed) || (x == reversed / 10);
  }
}