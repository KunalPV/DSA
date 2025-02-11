
// String, Stack

// Solution 1: Stack 
// create Stack st, loop ch through s.toCharArray(), 
// check if ch equals '*' and st NOT empty, if yes then st.pop(), 
// else if ch NOT equals '*', if yes st.push(ch),
// create StringBuilder sb, loop ch through st, sb.append(ch),
// return sb.toString();

// Solution 2: No Stack, Only StringBuilder
// create StringBuilder sb, loop ch through s.toCharArray(),
// check if ch NOT equals '*', if yes then sb.append(ch),
// else if NOT sb.isEmpty(), is yes then sb.deleteCharAt(sb.length() - 1);
// return sb.toString();

// Both have same time and space, but Solution 2 is better than Solution 1, as stack operations have extra overhead, and also Solution 2 avoids extra object storage.

import java.util.*;

// Expected Solution: Using Stack [Intented way]
// Time: O(n), n [s.chararray] + m [stack to sb] -> n, n = s.length()
// Space: O(n), worst case: no '*', then stack == s == sb, n = s.length()
class Solution1 {
  public String removeStars(String s) {
    Stack<Character> st = new Stack<>();

    for (char ch : s.toCharArray()) {
      if (ch == '*' && !st.isEmpty()) {
        st.pop();
      }

      if (ch != '*') {
        st.push(ch);
      }
    }

    StringBuilder sb = new StringBuilder();

    for (char ch : st) {
      sb.append(ch);
    }

    return sb.toString();
  }
}

// Optimal Solution: No use of Stack, only StringBuilder
// Time: O(n), each char in s is visited once, n = s.length(),
// Space: O(n), worst case: no '*' in s, means sb == s, n = s.length()
class Solution2 {
  public String removeStars(String s) {
    StringBuilder sb = new StringBuilder();

    for (char ch : s.toCharArray()) {
      if (ch != '*') {
        sb.append(ch);
      } else if (!sb.isEmpty()) {
        sb.deleteCharAt(sb.length() - 1);
      }
    }

    return sb.toString();
  }
}