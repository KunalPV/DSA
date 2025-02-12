
// String, Stack

// Solution 1: Use of just a character stack to process string s
// create a Stack<Character> st, loop ch through s.toCharArray(),
// check if ch != ']', then st.push(ch),
// else, create a StringBuilder sb,
// loop till NOT sb.isEmpty and Character.isLetter(st.peek()), sb.insert(0, sb.pop())
// store sb in a String sub, clear sb
// loop till NOT sb.isEmpty and Character.isDigit(st.peek()), sb.insert(0, sb.pop())
// create count and store Integer.valueOf(sb.toString())
// loop till count-- > 0, loop c through sub.toCharArray(), st.push(c),
// create a res StringBuilder, loop till NOT st.isEmpty, res.insert(0, st.pop())
// return res.toString();

// Solution 2: Use of 2 stacks to keep track of Integer count and StringBuilder sb,
// create a Stack<Integer> st1, Stack<StringBuilder> st2, StringBuilder sb, and int n = 0,
// loop ch through s.toCharArray(),
// check if Character.isDigit(ch), then n = n * 10 + (ch - '0'),
// else if ch == '[', then push n and sb to st1 and st2 and clear them [n = 0 and sb = new StringBuilder()]
// else if ch == ']', then create count as st1.pop() and StringBuilder temp as sb, sb = st2.pop(), loop till count-- > 0, then sb.append(temp),
// else, sb.append(ch)
// return sb.toString();

// Both solutions have same time and space complexity, 
// but solution2 avoids excessive push and pop operations
// and String concatenation happens in sb, which reduces operations and overhead

import java.util.*;

// Good Solution: But takes time.
// Time: O(n * k), worst case repetition count is max ex: "3[2[abcd]]", n = s.length() and k = length of repetition count "abcd"
// Space: O(n), worst case: all char is stored in st, n = s.length()
class Solution1 {
  public String decodeString(String s) {
    Stack<Character> st = new Stack<>();

    for (char ch : s.toCharArray()) {
      if (ch != ']') {
        st.push(ch);
      } else {
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty() && Character.isLetter(st.peek())) {
          sb.insert(0, st.pop());
        }

        String sub = sb.toString();
        st.pop();

        sb = new StringBuilder();
        while (!st.isEmpty() && Character.isDigit(st.peek())) {
          sb.insert(0, st.pop());
        }

        int count = Integer.valueOf(sb.toString());

        while (count-- > 0) {
          for (char c : sub.toCharArray()) {
            st.push(c);
          }
        }
      }
    }

    StringBuilder res = new StringBuilder();
    while (!st.isEmpty()) {
      res.insert(0, st.pop());
    }

    return res.toString();
  }
}

// Optimal Solution: Good use of Stack memory [Optimized]

// Time: O(n * k), worst case: each char in s is visited once and repetition
// string length is big ex: "3[2[abcde]]", so repetition string = "abcde" -> k,
// n = s.length() and k = length of repetition string

// Space: O(n), st1 [n] + st2 [n] + sb [n] -> n, n = s.length()
class Solution2 {
  public String decodeString(String s) {
    Stack<Integer> st1 = new Stack<>();
    Stack<StringBuilder> st2 = new Stack<>();
    StringBuilder sb = new StringBuilder();
    int n = 0;

    for (char ch : s.toCharArray()) {
      if (Character.isDigit(ch)) {
        n = n * 10 + (ch - '0');
      } else if (ch == '[') {
        st1.push(n);
        n = 0;

        st2.push(sb);
        sb = new StringBuilder();
      } else if (ch == ']') {
        int count = st1.pop();
        StringBuilder temp = sb;

        sb = st2.pop();

        while (count-- > 0) {
          sb.append(temp);
        }
      } else {
        sb.append(ch);
      }
    }

    return sb.toString();
  }
}