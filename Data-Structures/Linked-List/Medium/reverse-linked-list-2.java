// Linked List, 4 pointers

// create a dummy node and set its next to head and set before to dummy node
// loop with before till you reach left - 1, set curr to before.next and after to curr.next
// 1st change the node pointer of curr.next to after.next, then change pointer of after.next to before.next, then set before.next to after and finally set after to curr.next
// return dummy.next

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
  public ListNode reverseBetween(ListNode head, int left, int right) {
    if (head == null)
      return head;

    ListNode dummyHead = new ListNode(0);
    dummyHead.next = head;
    ListNode before = dummyHead;

    for (int i = 0; i < left - 1; i++) {
      before = before.next;
    }

    ListNode curr = before.next;
    ListNode after = curr.next;

    for (int i = 0; i < right - left; i++) {
      curr.next = after.next;
      after.next = before.next;
      before.next = after;
      after = curr.next;
    }

    return dummyHead.next;
  }
}