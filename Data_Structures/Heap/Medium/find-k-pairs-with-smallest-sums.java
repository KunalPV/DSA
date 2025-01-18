
// Array, Heap (Priority Queue)

// create a list of list -> result and a PriorityQueue -> pq with lambda function (a, b) -> a[0] - b[0]. (compare 1st index elem of pq int[] element) (small to large)
// loop through nums1 and add the (sum of nums1 and nums2[0], index of nums1 -> 0)
// run loop till k > 0 and pq is not empty, poll the pair, sum = pair[0], pos = pair[1] and create a Arraylist currPair and add the (sum - nums2[pos]) and (nums2[pos]) to currPair and add this currPair to result list.
// check if pos + 1 < nums2.length, if yes offer the new int[] {sum - nums2[pos] + nums2[pos + 1], pos + 1} and decrement the k value by 1 at the end of the loop
// return result

import java.util.*;

class Solution {
  public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    List<List<Integer>> res = new ArrayList<>();
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

    for (int x : nums1) {
      pq.offer(new int[] { x + nums2[0], 0 });
    }

    while (k > 0 && !pq.isEmpty()) {
      int[] pair = pq.poll();
      int sum = pair[0];
      int pos = pair[1];

      List<Integer> currentPair = new ArrayList<>();
      currentPair.add(sum - nums2[pos]);
      currentPair.add(nums2[pos]);
      res.add(currentPair);

      if (pos + 1 < nums2.length) {
        pq.offer(new int[] { sum - nums2[pos] + nums2[pos + 1], pos + 1 });
      }

      k--;
    }

    return res;
  }
}