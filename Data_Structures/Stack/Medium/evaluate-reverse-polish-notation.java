
// Stack, String, Math

// create a integer stack, run a loop through tokens, and check if each elem is equal to "+", "-", "*", "/"
// "+" -> stack push(pop + pop)
// "*" -> stack push(pop * pop)
// "-" -> a = pop, b = pop, stack push(a - b)
// "/" -> b = pop, a = pop, stack push(a / b)
// else push the num to stack
// return stack.pop()

import java.util.*;

class Solution {
  public int evalRPN(String[] tokens) {
    Stack<Integer> s = new Stack<>();
    int a, b;

    for (String t : tokens) {
      if (t.equals("+")) {
        s.push(s.pop() + s.pop());
      } else if (t.equals("*")) {
        s.push(s.pop() * s.pop());
      } else if (t.equals("/")) {
        b = s.pop();
        a = s.pop();
        s.push(a / b);
      } else if (t.equals("-")) {
        b = s.pop();
        a = s.pop();
        s.push(a - b);
      } else {
        s.push(Integer.parseInt(t));
      }
    }

    return s.pop();
  }
}