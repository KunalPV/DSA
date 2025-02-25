
// Queue, PriorityQueue, Heap
//
// declare a minNum and PriorityQueue<Integer> minHeap,
// ** constructor func() -> assign minNum = 1 and minHeap = new PriorityQueue<>(),
// ** addBack(int num) 
// -> check if(minNum > num && !minHeap.contains(num)), if yes minHeap.offer(num),
// ** popSmallest()
// -> check if(!minHeap.isEmpty()), if yes return minHeap.pop(),
// -> increment minNum by 1 and return minNum - 1;
//
import java.util.*;

// Expected Solution: min-heap using PriorityQueue
// Time: addBack() -> O(n) [minHeap.contains() takes O(n) time to lookup] and popSmallest() -> O(logn) [minHeap.poll() takes O(logn) time], n = num of elems added to minHeap
// Space: O(n), O(n) [minHeap stores upto n elems], n = num of elems in minHeap
class SmallestInfiniteSet {

    private Integer minNum;
    private final PriorityQueue<Integer> minHeap;

    public SmallestInfiniteSet() {
        minNum = 1;
        minHeap = new PriorityQueue<>();
    }

    public int popSmallest() {
        if (!minHeap.isEmpty()) {
            return minHeap.poll();
        }

        minNum++;
        return minNum - 1;
    }

    public void addBack(int num) {
        if (minNum > num && !minHeap.contains(num)) {
            minHeap.offer(num);
        }
    }
}
