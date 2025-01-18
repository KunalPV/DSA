
// Stack, Linked-List/ArrayList/Array

// * pop, top and getMin will always be called on non-empty stack.

// create a head node and private Node class with data, min and node as parameters
// push -> if head is empty (head == null) create new node with data, min and node as null and set it as head, else create new node with data, Math.min(data, head.min) and head, and assign it to head
// pop -> head = head.next;
// top -> return head.val;
// getMin -> return head.min;

class MinStack {
  private Node head;

  private class Node {
    int data;
    int min;
    Node next;

    private Node(int data, int min, Node next) {
      this.data = data;
      this.min = min;
      this.next = next;
    }
  }

  public MinStack() {
  }

  public void push(int val) {
    if (head == null) {
      head = new Node(val, val, null);
    } else {
      head = new Node(val, Math.min(val, head.data), head);
    }
  }

  public void pop() {
    head = head.next;
  }

  public int top() {
    return head.data;
  }

  public int getMin() {
    return head.min;
  }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */