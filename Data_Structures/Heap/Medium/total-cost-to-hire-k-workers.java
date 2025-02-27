
// Array, PriorityQueue, Heap
//
// create 2 pointers i and j as 0 and costs.length - 1,
// create 2 PriorityQueue<Integer> pq1 and pq2, and long ans = 0,
// loop till (k-- > 0), 
// loop till (pq1.size() < candidates and i <= j), if yes pq1.offer(costs[i++]),
// loop till (pq2.size() < candidates and i <= j), if yes pq2.offer(costs[j--]),
// create cost1 as pq1.size() > 0 ? pq1.peek() : Integer.MAX_VALUE,
// create cost2 as pq2.size() > 0 ? pq2.peek() : Integer.MAX_VALUE,
// check if(cost1 <= cost2), if yes ans += cost1 and pq1.poll(),
// else, ans += cost2 and pq2.poll(),
// return ans;
//
import java.util.*;

// Expected Solution: Using 2 PriorityQueues
// Time: O(n logn), O(2n) -> O(n) [2 * candidates] + O(n logn) [(candidates + k) log candidates, where candidates and k almost equals to n] -> O(n logn), n = size of costs
// Space: O(n), both pq size == candidates, n = candidates
class Solution {

    public long totalCost(int[] costs, int k, int candidates) {
        int i = 0;
        int j = costs.length;

        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();

        long ans = 0;
        while (k-- > 0) {
            while (pq1.size() < candidates && i <= j) {
                pq1.offer(costs[i++]);
            }
            while (pq2.size() < candidates && i <= j) {
                pq2.offer(costs[j--]);
            }

            int cost1 = pq1.size() > 0 ? pq1.peek() : Integer.MAX_VALUE;
            int cost2 = pq2.size() > 0 ? pq2.peek() : Integer.MAX_VALUE;

            if (cost1 <= cost2) {
                ans += cost1;
                pq1.poll();
            } else {
                ans += cost2;
                pq2.poll();
            }
        }

        return ans;
    }
}
