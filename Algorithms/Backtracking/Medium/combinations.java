
// Backtracking

// create a list of lists and return it if k > n or k == 0, else run backtrack(result, new ArrayList<>(), 1, n, k)
// backtrack(List<List<Integer>> result, List<Integer> list, int start, int n, int k), run a loop from start to n (including n (<=)), add the i index to the list, and call backtrack() again with i + 1 as start value, and finally remove the last elem from the list (list.remove(list.size() - 1))
// ** bounding function here is if list size is same as k (list.size() == k)then add the list to result (result.add(new ArrayList<>(list))) and return;

package Algorithms.Backtracking.Medium;

import java.util.*;

class Solution {
  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();

    if (k > n) {
      return result;
    }

    backtrack(result, new ArrayList<>(), 1, n, k);

    return result;
  }

  private void backtrack(List<List<Integer>> result, List<Integer> list, int start, int n, int k) {
    if (list.size() == k) {
      result.add(new ArrayList<>(list));
      return;
    }

    for (int i = start; i <= n; i++) {
      list.add(i);

      backtrack(result, list, i + 1, n, k);

      list.remove(list.size() - 1);
    }

  }
}
