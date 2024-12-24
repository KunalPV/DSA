import java.util.*;

// Arrays, Intervals

// run the loop on nums, inside run a while loop till the difference is 1 for nums[i] and nums[i + 1] and increase i value inside the while loop.
// if i value is changed then add "num->nums[i]" else print "num".

class Solution {
  public List<String> summaryRanges(int[] nums) {
    int n = nums.length;
    List<String> list = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      int num = nums[i];

      while (i + 1 < n && nums[i + 1] - nums[i] == 1) {
        i++;
      }

      if (num != nums[i]) {
        list.add(num + "->" + nums[i]);
      } else {
        list.add(num + "");
      }
    }

    return list;
  }
}