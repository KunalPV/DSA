
// Linked List, Two Pointers

// Get the mid and end of list
// create 2 pointer Node slow and fast as head and head,
// loop till fast and fast.next NOT equals null, set slow to slow.next and fast to fast.next.next,

// head = start, slow = mid, fast = last
// 1 -> 2 -> 3 -> 4 -> 5 -> 6

// Reverse the second half of the list
// create 2 pointer Node nextNode and prev as undefined and null,
// loop till slow NOT equals null, set slow.next to nextNode, slow.next to prev, prev to slow, slow to nextNode,

// head = start, slow = last
// 1 -> 2 -> 3 <- 4 <- 5 <- 6

// Calc maxVal from start and end [pair]
// loop till slow NOT equals null,
// set maxVal to max(maxVal, head.val + slow.val), head to head.next and slow to slow.next,

// return maxVal;

class ListNode {
  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

// Optimal Solution

// Time: O(n), n/2 [slow, fast pointer] + n/2 [reverse second half of list] +
// n/2 [calc maxVal] -> n, n = list length

// Space: O(1), modifies list in-place, constant place
class Solution {
  public int pairSum(ListNode head) {
    ListNode slow = head, fast = head;
    int maxVal = 0;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    ListNode nextNode, prev = null;
    while (slow != null) {
      nextNode = slow.next;
      slow.next = prev;
      prev = slow;
      slow = nextNode;
    }

    while (prev != null) {
      maxVal = Math.max(maxVal, head.val + prev.val);
      prev = prev.next;
      head = head.next;
    }

    return maxVal;
  }
}
