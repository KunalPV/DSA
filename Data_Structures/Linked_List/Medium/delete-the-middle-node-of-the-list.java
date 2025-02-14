
// Linked List, Two Pointers

// create a Node prev = 0, set prev.next = head,
// create 2 pointer Node slow and fast as prev and head, 
// loop till fast and fast.next NOT equals null, set slow to slow.next and fast to fast.next.next,
// set slow.next to slow.next.next, [set (mid - 1) node to (mid + 1) node = deleting mid]
// return head;

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

// Expected Solution: Slow and Fast pointers
// Time: O(n), n/2 [slow, fast pointers both half of list] -> n, n = list length
// Space: O(1), 1 [prev] + 1 [slow] + 1 [fast] -> 1 [all pointers] constant time
class Solution {
  public ListNode deleteMiddle(ListNode head) {
    if (head == null || head.next == null) {
      return null;
    }

    ListNode prev = new ListNode(0);
    prev.next = head;

    ListNode slow = prev;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    slow.next = slow.next.next;

    return head;
  }
}
