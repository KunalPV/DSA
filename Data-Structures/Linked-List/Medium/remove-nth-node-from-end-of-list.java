
// Linked List, Two pointers

// Solution 1:
// loop through list once and store the length, then distance = length - n, loop through distance, if distance is same as length then head = head.next, else curr.next = curr.next.next and return head

// Solution 2:
// create 2 node pointers slow and fast which start at head, loop till n and set fast = fast.next
// if fast is null, return head.next
// loop till fast.next is not null and update slow and fast to slow.next and fast.next
// set slow.next to slow.next.next and return head

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

class Solution2 {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    if (head == null)
      return head;

    ListNode fast = head, slow = head;
    for (int i = 0; i < n; i++)
      fast = fast.next;

    if (fast == null)
      return head.next;

    while (fast.next != null) {
      fast = fast.next;
      slow = slow.next;
    }

    slow.next = slow.next.next;

    return head;
  }
}

class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    if (head == null)
      return null;

    int len = 0;

    ListNode curr = head;
    while (curr != null) {
      len++;
      curr = curr.next;
    }

    int idx = len - n;

    curr = head;
    for (int i = 1; i < idx; i++) {
      curr = curr.next;
    }

    if (len == n) {
      head = head.next;
    } else {
      curr.next = curr.next.next;
    }

    return head;
  }
}