
// Linked List, Recursion

// Solution 1: Iterative approach
// create a pointer ListNode newHead as null,
// loop till head != null, create a pointer ListNode after as head.next,
// set head.next = newHead, and set newHead = head, and set head = after,
// return newHead;

// Solution 2: Recursive approach
// return reverseList(head, null);
// ListNode reverseList(ListNode head, ListNode newHead) ->
// ** check if head == null, if yes return newHead;
// create a ListNode after as head.next, set head.next = newHead,
// return reverseList(after, head);

package Data_Structures.Linked_List.Easy;

class ListNode {
  int val;
  ListNode next;

  ListNode() {
  };

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

// Optimal Solution: Iterative Solution
// Time: O(n), each node is visited exactly once, n = list length

// Space: O(1), 1 [newHead] + 1 [after] -> 1, constant time [newHead and after
// are pointers]
class Solution1 {
  public ListNode reverseList(ListNode head) {
    ListNode newHead = null;

    while (head != null) {
      ListNode after = head.next;
      head.next = newHead;
      newHead = head;
      head = after;
    }

    return newHead;
  }
}

// Optimal Solution: Recursive Solution
// Time: O(n), each recursion call processes one node, n = list length

// Space: O(n), each recursion call adds to the call stack, so n nodes = n
// recursion call stack, n = list length
class Solution2 {
  public ListNode reverseList(ListNode head) {
    return reverseList(head, null);
  }

  private ListNode reverseList(ListNode head, ListNode newHead) {
    if (head == null) {
      return newHead;
    }

    ListNode after = head.next;
    head.next = newHead;
    return reverseList(after, head);
  }
}