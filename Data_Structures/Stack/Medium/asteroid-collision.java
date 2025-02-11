
// Array, Stack

// create a stack st, loop a through asteroids,
// check if a > 0, if yes then st.push(a), [asteroid moving right]
// else, loop till NOT st.isEmpty() and 0 < st.peek() < -a, then st.pop(); [right moving asteroid gets destroyed]
// check if st.isEmpty() and st.peek() < 0, then st.push(a), [left moving asteroid survives]
// check if st.peek() == -a, then st.pop(), [both asteroids explode due to same size]
// create a res array with "st.size()" size, and create i as st.size() - 1,
// loop till NOT st.isEmpty(), res[i--] = st.pop(),
// return res;

import java.util.*;

// Expected Solution: Stack
// Time: O(n), each elem in asteroids is visited once, n = asteroids.length
// Space: O(n), worst case: no collision, then st.size() == asteroids.length + also res.length == asteroids.length, n = asterpoids.length
class Solution {
  public int[] asteroidCollision(int asteroids[]) {
    Stack<Integer> st = new Stack<>();

    for (int a : asteroids) {
      if (a > 0) {
        st.push(a);
      } else {
        while (!st.isEmpty() && st.peek() > 0 && st.peek() < -a) {
          st.pop();
        }

        if (st.isEmpty() || st.peek() < 0) {
          st.push(a);
        }

        if (st.peek() == -a) {
          st.pop();
        }
      }
    }

    int res[] = new int[st.size()];
    int i = st.size() - 1;

    while (!st.isEmpty()) {
      res[i--] = st.pop();
    }

    return res;
  }
}
