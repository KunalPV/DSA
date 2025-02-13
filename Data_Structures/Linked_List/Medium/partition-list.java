// Linked List, Two pointers

// create 2 new list left and right with a non-null value, and create two node pointers leftTail and rightTail which will be the tail after the loop
// loop through given loop, if curr.val < x then add it to left list and left = left.next, else add it to right and right = right.next
// if leftTail is not null then add right list to leftTail, else return right.next
// return left.next

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
  public ListNode partition(ListNode head, int x) {
    if (head == null || head.next == null)
      return head;
    ListNode left = new ListNode(0);
    ListNode right = new ListNode(0);

    ListNode leftTail = left;
    ListNode rightTail = right;

    ListNode curr = head;
    while (curr != null) {
      ListNode newNode = new ListNode(curr.val);
      if (curr.val < x) {
        leftTail.next = newNode;
        leftTail = leftTail.next;
      } else {
        rightTail.next = newNode;
        rightTail = rightTail.next;
      }

      curr = curr.next;
    }

    if (leftTail != null) {
      leftTail.next = right.next;
    } else {
      return right.next;
    }

    return left.next;
  }
}