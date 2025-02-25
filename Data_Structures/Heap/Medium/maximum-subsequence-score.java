
// Array, Sorting, Priority Queue, Heap
//
// create an int arr[n][2], loop i = 0 till n, arr[i] = new int[] {nums2[i], nums1[i]},
// sort using Arrays.sort(arr, (a,b) -> b[0] - a[0]) [descending based on 1st elem in arr],
// create a PriorityQueue<Integer> pq, res = 0 and sum = 0,
// loop int[] a through arr, pr.offer(a[1]), sum += a[1],
// check if(pq.size() > k), if yes sum -= pq.poll(),
// check if(pq.size() == k), if yes res = Math.max(res, (sum * a[0])),
// return res;
//
import java.util.*;

// Expected Solution
// Time: O(nlogn + nlogk), O(n logn) [sorting] + O(n) [iterating through array] + O(n logk) [insertion: logk and it runs upto n times] -> O(n logn) + (n logk)
// Space: O(n + k), O(n) [array size == nums1/nums2 length] + O(k) [pq stores upto k elems] -> O(n), n = size of nums1/nums2
class Solution {

    public int maxScore(int nums1[], int nums2[], int k) {
        int n = nums1.length;

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i] = new int[]{nums2[i], nums1[i]};
        }

        Arrays.sort(arr, (a, b) -> b[0] - a[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int res = 0, sum = 0;

        for (int[] a : arr) {
            pq.offer(a[1]);
            sum += a[1];

            if (pq.size() > k) {
                sum -= pq.poll();
            }
            if (pq.size() == k) {
                res = Math.max(res, (sum * a[0]));
            }
        }

        return res;
    }
}
