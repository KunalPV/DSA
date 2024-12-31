
// Array, Divide and Conquer, Sorting, Heap(Priority Queue), Quickselect

// Min-heap = PriorityQueue<Generic> minHeap = new PriorityQueue<>();
// Max-heap = PriorityQueue<Generic> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

// create a priority queue (aka min heap), and **offer (returns false if empty, add -> returns error) elements from array till k index.
// make another loop which runs from k till end of array, check if current elem of array is greater than heap.peek() (returns false, element() -> returns error).
// if yes then poll() (returns false, remove() -> returns error) and offer(nums[i])
// return heap.poll() at the end.

import java.util.PriorityQueue;

class Solution {
  public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    for (int i = 0; i < k; i++) {
      minHeap.offer(nums[i]);
    }

    for (int i = k; i < nums.length; i++) {
      if (nums[i] > minHeap.peek()) {
        minHeap.poll();
        minHeap.offer(nums[i]);
      }
    }

    return minHeap.peek();
  }
}