
// Array, Backtracking

// create a result list of lists, and call backtrack(results, new ArrayList<>(), nums) and return the lists
// backtrack(List<List<Integer>> result, List<Integer> list, int nums[]), run a loop from 0 till nums.length, check if list not contains nums[i] elem (!list.contains(nums[i])), if true then add the nums[i] to the list. and call backtrack func again, and finally remove the last elem of the list.
// ** bounding function here is, if the length of list and length of nums array are same then make an ArrayList of list and add it to the result (result.add(new ArrayList<>(list))) and return;

package Algorithms.Backtracking.Medium;

import java.util.*;

public class permutations {
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();

    backtrack(result, new ArrayList<>(), nums);

    return result;
  }

  private void backtrack(List<List<Integer>> result, List<Integer> list, int nums[]) {
    if (list.size() == nums.length) {
      result.add(new ArrayList<>(list));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      if (!list.contains(nums[i])) {
        list.add(nums[i]);

        backtrack(result, list, nums);

        list.remove(list.size() - 1);
      }
    }
  }
}
