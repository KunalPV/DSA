
// Array, Hashing, HashMap, HashSet, Two-Pointers

// Solution1: Output: { num[i], num[j] } or { i, j } / { -1, -1 }
// run a loop till n, if map contains (target - arr[i]) ? return { get(i), i } : put(target - nums[i], i)

// Solution2: Output: true / false
// run a loop till n, get compliment = target - nums[i],
// if set contains compliment ? true : add nums[i] to set

// Solution3: Output: true / false [SORTED ARRAY]
// create 2 pointers left = 0 and right = n - 1,
// run loop till left < right, calculate sum = nums[left] + nums[right]
// if sum == target, return true
// if sum < target, left++;
// if sum > target, right--;

import java.util.*;

// Array, HashMap

// To find and return the nums or their index, Hashmap is better
// Time: O(n) => n = nums.length 
// Space: O(n) => all nums.length elems stored in hashmap
class Solution1 {
  public int[] twoSum(int nums[], int target) {
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

// To just return boolean if exists? then return true or false
// HashSet is better
// Time: O(n) n = nums.length
// Space: O(n) n = set stores all the nums.length elems
class Solution2 {
  public boolean twoSum(int nums[], int target) {
    int n = nums.length;
    Set<Integer> set = new HashSet<>();

    for (int i = 0; i < n; i++) {
      int complement = target - nums[i];

      if (set.contains(complement)) {
        return true;
      }

      set.add(nums[i]);
    }

    return false;
  }
}

// If array is sorted then Two pointer works the best as space will be O(1)
// Time: O(n), as it takes n iterations for the whole array (SORTED ARRAY)
// Time: O(n log n), sorting = n log n and two pointers = n (UNSORTED ARRAY)
// Space: O(left + right) = O(1 + 1) = O(1), constant time
class Solution3 {
  public boolean twoSum(int nums[], int target) { // nums[] = sorted arr
    int left = 0, right = nums.length - 1;

    while (left < right) {
      int sum = nums[left] + nums[right];

      if (sum == target) {
        return true;
      } else if (sum < target) {
        left++;
      } else {
        right--;
      }
    }

    return false;
  }
}