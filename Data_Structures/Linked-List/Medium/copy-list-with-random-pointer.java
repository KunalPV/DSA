import java.util.*;

// Linked List, HashTable

// loop through given list till null and store the Node into Hashmap as key and create a newNode with same value as key and store this newNode as value in Hashmap
// loop through given list and get the key and set its next and random pointer as get(curr.next) and get(curr.random)
// return map.get(head)

// Definition for a Node.
class Node {
  int val;
  Node next;
  Node random;

  public Node(int val) {
    this.val = val;
    this.next = null;
    this.random = null;
  }
}

class Solution {
  public Node copyRandomList(Node head) {
    if (head == null)
      return null;

    HashMap<Node, Node> map = new HashMap<>();

    Node curr = head;
    while (curr != null) {
      map.put(curr, new Node(curr.val));
      curr = curr.next;
    }

    curr = head;
    while (curr != null) {
      map.get(curr).next = map.get(curr.next);
      map.get(curr).random = map.get(curr.random);
      curr = curr.next;
    }

    return map.get(head);
  }
}