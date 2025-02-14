
// Linked List, Two Pointer

// create 3 pointer Node odd, even and evenHead as head, head.next and even,
// loop till even and even.next NOT equals null,
// set odd.next to odd.next.next, and even.next to even.next.next,
// set odd to odd.next, and even to even.next,
// set odd.next to evenHead,
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

// Expected Solution
// Time: O(n), each node is visited once in the list, n = list length

// Space: O(1), 1 [odd] + 1 [even] + 1 [evenHead] -> 1 [all 3 pointers],
// constant time
class Solution {
  public ListNode oddEvenList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode odd = head, even = head.next, evenHead = even;

    while (even != null && even.next != null) {
      odd.next = odd.next.next;
      even.next = even.next.next;
      odd = odd.next;
      even = even.next;
    }

    odd.next = evenHead;

    return head;
  }
}
