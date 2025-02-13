
// Linkedlist, Math

// create a dummyNode with 0 as val, set tail as dummyNode, create an int to store carry value
// loop when l1 != null or l2 != null or carry != 0, take val from node and store it to digit1 and digit2
// add both digit with carry and mod it get the unit value of int and divide it and set its val to carry
// create a newNode with unit value digit as val and set it to tail.next and update tail
// return dummyNode.next as the head

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
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode(0);
    ListNode tail = dummyHead;
    int carry = 0;

    while (l1 != null || l2 != null || carry != 0) {
      int digit1 = (l1 != null) ? l1.val : 0;
      int digit2 = (l2 != null) ? l2.val : 0;

      int sum = digit1 + digit2 + carry;
      int digit = sum % 10;
      carry = sum / 10;

      ListNode newNode = new ListNode(digit);
      tail.next = newNode;
      tail = tail.next;

      l1 = (l1 != null) ? l1.next : null;
      l2 = (l2 != null) ? l2.next : null;
    }

    return dummyHead.next;
  }
}