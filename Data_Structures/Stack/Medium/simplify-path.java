import java.util.*;

// Stack, String

// create a stack, a string array and split the path by "/" and store in the string array
// loop through string array and check if each elem is equal to "." or is empty, if yes then continue, else check for stack is empty and pop the elem from stack
// else push the elem to stack.
// ** return "/" + String.join("/", stack) -> ( "/" ) + stack[0] + "/" + stack[1] + "/" + ... + stack[n].

class Solution {
  public String simplifyPath(String path) {
    Stack<String> stack = new Stack<>();
    String[] directories = path.split("/");

    for (String dir : directories) {
      if (dir.equals(".") || dir.isEmpty()) {
        continue;
      } else if (dir.equals("..")) {
        if (!stack.isEmpty()) {
          stack.pop();
        }
      } else {
        stack.push(dir);
      }
    }

    return "/" + String.join("/", stack);
  }
}