import java.util.*;

// Array, HashMap

class Solution {
  public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i])) {
        int idx = map.get(nums[i]);
        return new int[] { idx, i };
      } else {
        map.put(target - nums[i], i);
      }
    }

    return new int[] { -1, -1 };
  }
}