
// Array, Backtracking

// create a list of lists result, and sort the given candidates array if not already sorted, then called func backtrack(result, new ArrayList<>(), candidates, target, 0) and return the result
// in the func backtrack(List<List<Integer>> result, List<Integer> list, int candidates[], int target, int index), run a loop from i = index till candidates.length, and add the candidates[i] to the list, call backtrack func but with target as target - candidates[i] and index param as i (this run the loop like same elem from candidates array till it matches the target or exceeds (in our case makes target 0 or goes less than 0)), and finally remove last elem of the list as we are backtracking.
// ** bounding function here is if target is less than 0 then just return, else if target equals to 0 then add the list to result (result.add(new ArrayList<>(list))) and return;

package Algorithms.Backtracking.Medium;

import java.util.*;

class Solution {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();

    // Arrays.sort(candidates); // sort if array is not sorted already

    backtrack(result, new ArrayList<>(), candidates, target, 0);

    return result;
  }

  private void backtrack(List<List<Integer>> result, List<Integer> list, int candidates[], int target, int index) {
    if (target < 0) {
      return;
    } else if (target == 0) {
      result.add(new ArrayList<>(list));
      return;
    }

    for (int i = index; i < candidates.length; i++) {
      list.add(candidates[i]);

      backtrack(result, list, candidates, target - candidates[i], i);

      list.remove(list.size() - 1);
    }
  }
}
