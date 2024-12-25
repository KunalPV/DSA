// Linked List, Two pointers

// create a dummy with some non node value, set its next to head, prev = dummy, curr = head
// loop till curr is null and increment curr to its next node, loop till curr.next is null and curr.val == curr.next.val
// if prev.next == curr that means no same val, prev = prev.next
// else it means val is same, prev.next = curr.next
// return head

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
  public ListNode deleteDuplicates(ListNode head) {
    if (head == null || head.next == null)
      return head;

    ListNode dummy = new ListNode(Integer.MIN_VALUE);
    dummy.next = head;
    ListNode prev = dummy;
    ListNode curr = head;

    while (curr != null) {
      while (curr.next != null && curr.val == curr.next.val) {
        curr = curr.next;
      }

      if (prev.next == curr) {
        prev = prev.next;
      } else {
        prev.next = curr.next;
      }

      curr = curr.next;
    }

    return dummy.next;
  }
}