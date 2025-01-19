
// Array, HashMap, Frequency Array/Map

// Solution1: Preferred
// create list and hashmap, loop through given nums array and add to the hashmap,
// if that num exists in hashmap, then increment the val by 1,
// loop through hashmap, and get all the key whose val > 1 and add to list
// return list;

// Solution2: Do when asked not to use HashMap [But each elem val < n, n = nums.length]
// create list and an auxillary array - freqArr (fancy name for basic array),
// loop through the nums array and freqArr[nums[i]]++;
// loop through the freqArr and add the elems whose (freq[nums[i]] > 1),
// if list is empty, then just add -1 to list,
// return list.stream().mapToInt(i -> i).toArray();

package Data_Structures.Array.Easy;

import java.util.*;

// Using HashMap
// Time: O(n), O(n + 1 + m) n = nums.length, m = hashmap length but n > m, so O(n)
// Space: O(n), worst case -> no duplicates, so hashmap length == given array length
class Solution1 {
  public List<Integer> findDuplicates(int nums[]) {
    int n = nums.length;
    List<Integer> list = new ArrayList<>();
    Map<Integer, Integer> freqMap = new HashMap<>();

    if (n == 0) {
      return list;
    }

    for (int i = 0; i < n; i++) {
      // if (freqMap.containsKey(nums[i])) {
      // int val = freqMap.get(nums[i]);
      // freqMap.put(nums[i], ++val);
      // } else {
      // freqMap.put(nums[i], 1);
      // }

      freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
    }

    for (Map.Entry<Integer, Integer> e : freqMap.entrySet()) {
      if (e.getValue() > 1) {
        list.add(e.getKey());
      }
    }

    return list;
  }
}

// Auxillary array -> elems value should be < nums.length
// Time: O(n), worst case -> O(n + n), n = nums.length
// Space: O(n), worst case -> no duplicates, so n = nums.length
class Solution2 {
  public int[] findDuplicates(int nums[]) {
    int n = nums.length;
    List<Integer> list = new ArrayList<>();
    int freqArr[] = new int[n];

    for (int i = 0; i < n; i++) {
      freqArr[nums[i]]++;
    }

    for (int i = 0; i < n; i++) {
      if (freqArr[nums[i]] > 1) {
        list.add(nums[i]);
        freqArr[nums[i]] = 0;
      }
    }

    if (list.isEmpty()) {
      list.add(-1);
    }

    return list.stream().mapToInt(i -> i).toArray();
  }
}