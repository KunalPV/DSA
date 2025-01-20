
// Array, ArrayList, HashMap, HashSet

// Solution1:
// create a result List<List<Integer>>
// loop i till n, nested loop j till n, and nested loop k till n,
// if nums[i] + nums[j] + nums[k] == 0, then create a list and add the i, j, k to list and add this list to result.
// return result;

// Solution2:
// create a hashset <List<Integer>> resSet, and a hashmap <Integer, List<int[]>>
// first loop i till n, and nested loop j till n, store all the possible pairs in the map
// then loop i till n, create var rem = -nums[i],
// if map contains rem, then List<int[]> pairs = map.get(rem),
// loop through the pairs list, check if i is not equal to p[0] or p[1],
// if yes, then create a list of (i, p[0], p[1]), sort list and add it to resSet,
// return new ArrayList<>(resSet);

import java.util.*;

// Brute Force
// Time: O(n^3), i * j * k, n = nums.length
// Space: O(k), k = list.length, almost constant space (auxillary space) 
class Solution1 {
  public List<List<Integer>> findTriplets(int nums[]) {
    int n = nums.length;
    List<List<Integer>> result = new ArrayList<>();

    for (int i = 0; i < n - 2; i++) {
      for (int j = i + 1; j < n - 1; j++) {
        for (int k = j + 1; k < n; k++) {
          if (nums[i] + nums[j] + nums[k] == 0) {
            List<Integer> list = new ArrayList<>();

            list.add(i);
            list.add(j);
            list.add(k);

            // Arrays.asList(i, j, k);

            result.add(list);
          }
        }
      }
    }

    return result;
  }
}

// Optimal Solution
// Time: O(n^2), (n * n) + n -> (n^2) + n -> n^2, n = nums.length
// Space: O(n^2), (n * n), n = nums.length [storing pairs in hashmap]
class Solution2 {
  public List<List<Integer>> findTriplets(int nums[]) {
    int n = nums.length;
    Set<List<Integer>> resSet = new HashSet<>();
    Map<Integer, List<int[]>> map = new HashMap<>();

    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        map.computeIfAbsent((nums[i] + nums[j]), k -> new ArrayList<>()).add(new int[] { i, j });
      }
    }

    for (int i = 0; i < n; i++) {
      int rem = -nums[i];

      if (map.containsKey(rem)) {
        List<int[]> pairs = map.get(rem);

        for (int[] p : pairs) {
          if (p[0] != i && p[1] != i) {
            List<Integer> list = new ArrayList<>(Arrays.asList(i, p[0], p[1]));

            Collections.sort(list);
            resSet.add(list);
          }
        }
      }
    }

    return new ArrayList<>(resSet);
  }
}