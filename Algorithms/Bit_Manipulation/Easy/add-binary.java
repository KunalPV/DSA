
// Math, String, Bit Manipulation, Simulation

// create a StringBuilder res and i, j, and carry where i and j will be the last index of the given 2 strings a.length() - 1, b.length() - 1, and assign 0 to carry,
// run a loop till i >= 0 or j >= 0, declare and set sum as carry, then check if i >= 0, if yes then add sum + a.charAt(i) - '0' to sum and decrement i, 
// same with j, check if j >= 0, if yes then add sum + b.charAt(j) - '0' to sum and decrement j, the check for carry,
// carry can be set in 2 ways, 1. check if sum > 0, if yes then set 1 or else 0 (sum > 1 ? 1 : 0), 2. just divide sum by 2, then append the sum % 2 to res.
// then check if carry != 0, if yes then append carry to res,
// finally return the res by reversing it and converting it to string(res.reverse().toString())

package Algorithms.Bit_Manipulation.Easy;

class Solution {
  public String addBinary(String a, String b) {
    StringBuilder res = new StringBuilder();
    int i = a.length() - 1;
    int j = b.length() - 1;
    int carry = 0;

    while (i >= 0 || j >= 0) {
      int sum = carry;

      if (i >= 0) {
        sum += a.charAt(i--) - '0';
      }
      if (j >= 0) {
        sum += b.charAt(j--) - '0';
      }

      carry = sum > 1 ? 1 : 0;
      res.append(sum % 2);
    }

    if (carry != 0) {
      res.append(carry);
    }

    return res.reverse().toString();
  }
}
