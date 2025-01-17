
// Math, Dynamic Programming, Memoization

// create a hashmap memo,
// create a recursive function and pass n and memo to it,
// climbStairs(int n, Map<Integer, Integer> memo), check if memo doesn't contains the key n, if yes then map.put(n, climbstairs(n - 1, memo) + climbstairs(n - 2, memo)),
// return memo.get(n) as the n contains the value of total combinations of climbing,
// ** bounding function, check is n equals 0 or 1, if yes return 1;
// return climbStairs(n, memo) in the main function.

// for n = 4 and memo => 
// n = 2 and { {2, 2} } -> 
// n = 3 and { {2, 2}, {3, 3} }
// n = 2 and { {2, 2}, {3, 3} }
// n = 4 and { {2, 2}, {3, 3}, {4, 5} }
// return memo.get(4) => 5

package Algorithms.Dynamic_Programming.Easy;

import java.util.*;

class Solution {
  public int climbStairs(int n) {
    Map<Integer, Integer> memo = new HashMap<>();

    return climbStairs(n, memo);
  }

  private int climbStairs(int n, Map<Integer, Integer> memo) {
    if (n == 0 || n == 1) {
      return 1;
    }

    if (!memo.containsKey(n)) {
      memo.put(n, climbStairs(n - 1, memo) + climbStairs(n - 2, memo));
    }

    return memo.get(n);
  }
}
