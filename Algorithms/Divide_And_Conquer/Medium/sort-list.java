
// Linked List, Two Pointers, Divide and Conquer, Sorting, Merge Sort

// Solution 1: (more time, less space)
// create a ArrayList, loop through linked list, store the val in ArrayList, loop through the linked list again, and assign ArrayList vals and increment i by 1 each time and return head.

// Solution 2: (less time, a bit more space)
// return head if head is null or head.next is null, create 3 ListNode, prev = null, and slow, fast as head. loop till fast or fast.next is not null, prev = slow, slow = slow.next and fast = fast.next.next. And set prev.next as null
// make 2 ListNode l1 and l2, and call sortList func on head and slow.
// finally return mergeList(l1, l2)
// in mergeList(ListNode l1, ListNode l2), create a ListNode l with some dummy info as val, and another ListNode p = l. loop till l1 != null and l2 != null, if l1.val < l2.val then p.next = l1 and update l1 to l1.next, else same process but with l2. but also update p to p.next out of if-else and inside while loop.
// if there are any l1 or l2 left which is not joined to p then check and update p, l1 is not null then p.next = l1, l2 is not null then p.next = l2. Finally return l.next;

package Algorithms.Divide_And_Conquer.Medium;

import java.util.*;

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

class Solution1 {
  // Sorting using ArrayList
  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ArrayList<Integer> list = new ArrayList<>();
    ListNode curr = head;

    while (curr != null) {
      list.add(curr.val);
      curr = curr.next;
    }

    curr = head;
    int i = 0;
    while (curr != null) {
      curr.val = list.get(i);
      curr = curr.next;
      i++;
    }

    return head;
  }
}

class Solution2 {
  // Sort using Divide And Conquer using Recursion and Merge Sort.
  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode prev = null, slow = head, fast = head;
    while (fast != null && fast.next != null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next.next;
    }

    prev.next = null;

    ListNode l1 = sortList(head);
    ListNode l2 = sortList(slow);

    return mergeList(l1, l2);
  }

  private ListNode mergeList(ListNode l1, ListNode l2) {
    ListNode l = new ListNode(0);
    ListNode p = l;

    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        p.next = l1;
        l1 = l1.next;
      } else {
        p.next = l2;
        l2 = l2.next;
      }
      p = p.next;
    }

    if (l1 != null) {
      p.next = l1;
    }

    if (l2 != null) {
      p.next = l2;
    }

    return l.next;
  }
}
