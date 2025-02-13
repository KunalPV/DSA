
// Linked List, Two pointer, Math

// create a dummy node and set its next to head, create slow and fast node pointer and assign it to dummy
// loop through whole list to get the size
// loop till len - k % len node, then set fast.next to dummy.next and dummy.next to slow.next and set slow.next to null
// return dummy.next;

// Definition for singly-linked list.
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

class Solution {
  public ListNode rotateRight(ListNode head, int k) {
    if (head == null || head.next == null || k == 0)
      return head;

    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode fast = dummy, slow = dummy;

    int i;
    for (i = 0; fast.next != null; i++) {
      fast = fast.next;
    }

    for (int j = i - k % i; j > 0; j--) {
      slow = slow.next;
    }

    fast.next = dummy.next;
    dummy.next = slow.next;
    slow.next = null;

    return dummy.next;
  }
}