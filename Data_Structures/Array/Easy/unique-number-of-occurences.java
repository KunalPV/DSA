
// Array, HashSet, HashMap

// create a HashMap map, loop through nums map.put(num, map.getOrDefault(num, 0) + 1),
// create a HashSet set, loop through map.values() and check if !set.add(count), if yes then return false;, 
// [set.add(num) returns if num is being added for the first time, else returns false]
// return true;

package Data_Structures.Array.Easy;

import java.util.*;

// Optimal Solution
// Time: O(n), loop of nums [n] + map.values() [n] -> n, n = nums.length
// Space: O(n), worst case all unique elems of nums in Hashmap, n = nums.length
class Solution {
  public boolean uniqueOccurances(int nums[]) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    Set<Integer> set = new HashSet<>();
    for (int count : map.values()) {
      if (!set.add(count)) {
        return false;
      }
    }

    return true;
  }
}
