
// String, Dynamic Programming, Backtracking

// create a string arraylist result and call backtrack(result, new StringBuilder(), n, 0, 0) and return the list.
// in backtrack(List<String> result, StringBuilder currStr, int n, int open, int close), check if ** open is less then n, if yes then append "(" to currStr and call backtrack(result, currStr, n, open + 1, close) and delete char at last elem in currStr. And check if ** close is less then ** open, if yes then append ")" to currStr and call backtrack(result, currStr, n, open, close + 1) and delete char at last elem in currStr.
// ** bounding function here is check if currStr.length() equals to 2 * n, if yes then add the currStr.toString() to result and return;

package Algorithms.Backtracking.Medium;

import java.util.*;

class Solution {
  public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();

    backtrack(result, new StringBuilder(), n, 0, 0);

    return result;
  }

  private void backtrack(List<String> result, StringBuilder currStr, int n, int open, int close) {
    if (currStr.length() == n * 2) {
      result.add(currStr.toString());
      return;
    }

    if (open < n) {
      currStr.append("(");

      backtrack(result, currStr, n, open + 1, close);

      currStr.deleteCharAt(currStr.length() - 1);
    }
    if (close < open) {
      currStr.append(")");

      backtrack(result, currStr, n, open, close + 1);

      currStr.deleteCharAt(currStr.length() - 1);
    }
  }
}
