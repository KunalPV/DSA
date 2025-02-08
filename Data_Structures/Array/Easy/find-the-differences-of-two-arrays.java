
// Array, HashSet, List

// create two HashSet set1 and set2, fill up both set with nums1 and nums2,
// create a list of list result and add two lists to result,
// loop through set1, check if set2 NOT contains num, if yes then add num to result.get(0)
// loop through set2, check if set1 NOT contains num, if yes then add num to result.get(1)
// return result;

package Data_Structures.Array.Easy;

import java.util.*;

// Optimal Solution
// Time: O(n), loop of nums1 + nums2 + set1 + set2 -> n, n = which ever array is bigger between nums1 or nums2
// Space: O(m), set1 + set2 + result -> m, worst case all distint elems in either nums1 or nums2 or both, so either set1 or set2 or both, m = biggest set
class Solution {
  public List<List<Integer>> findDifference(int nums1[], int nums2[]) {
    Set<Integer> set1 = new HashSet<>();
    Set<Integer> set2 = new HashSet<>();

    for (int num : nums1) {
      set1.add(num);
    }

    for (int num : nums2) {
      set2.add(num);
    }

    List<List<Integer>> result = new ArrayList<>();
    result.add(new ArrayList<>());
    result.add(new ArrayList<>());

    for (int num : set1) {
      if (!set2.contains(num)) {
        result.get(0).add(num);
      }
    }

    for (int num : set2) {
      if (!set1.contains(num)) {
        result.get(1).add(num);
      }
    }

    return result;
  }
}
