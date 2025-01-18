import java.util.*;

// Array, HashSet

// Add array to set to remove duplicates
// run a loop on the array and check for --num and ++num in a while loop, if exists then remove it from set
// update max variable to max-value on every iteration and return

class Solution {
  public int longestConsecutive(int[] nums) {
    int n = nums.length, max = 0;

    Set<Integer> set = new HashSet<>();

    for (int num : nums) {
      set.add(num);
    }

    for (int i = 0; i < n; i++) {
      int count = 1;

      int num = nums[i];
      while (set.contains(--num)) {
        count++;
        set.remove(num);
      }

      num = nums[i];
      while (set.contains(++num)) {
        count++;
        set.remove(num);
      }

      max = Math.max(max, count);
    }

    return max;
  }
}