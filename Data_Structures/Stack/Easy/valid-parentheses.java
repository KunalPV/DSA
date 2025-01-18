import java.util.*;

// Stack, String

// run a loop for the string and check each elem in string and if its equal to {'(', '{', '['} then add corresponding {')', '}', ']'} to stack
// and check if stack is empty or is the i'th character is not equal to stack.pop, if yes then return false
// return stack.isEmpty at the end of func

class Solution {
  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();

    for (char c : s.toCharArray()) {
      if (c == '(') {
        stack.push(')');
      } else if (c == '{') {
        stack.push('}');
      } else if (c == '[') {
        stack.push(']');
      } else if (stack.isEmpty() || c != stack.pop()) {
        return false;
      }
    }

    return stack.isEmpty();
  }
}

// No Stack used
class Solution2 {
  public boolean isValid(String s) {
    while (true) {
      if (s.contains("()")) {
        s = s.replace("()", "");
      } else if (s.contains("{}")) {
        s = s.replace("{}", "");
      } else if (s.contains("[]")) {
        s = s.replace("[]", "");
      } else {
        return s.isEmpty();
      }
    }
  }
}