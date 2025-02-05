
// String, Two-Pointers

// Solution 1: ASCII value check
// declare StringBuilder sb,
// loop char c through s [lower and to char array], check if 'A' <= c <= 'Z' or 'a' <= c <= 'z', if yes then append c to sb
// create 2 pointers left and right as 0 and sb.length() - 1,
// loop till left < right, check if sb[left] != sb[right], if yes then return false;
// return true;

// Solution 2: Using Character Wrapper Class
// create 2 pointers, left and right as 0 and s.length() - 1,
// loop till left < right,
// check if !Character.isLetterOrDigit(s[left]), if yes then left++,
// else if !Character.isLetterOrDigit(s[right]), if yes then right--,
// else if Character.isLetterOrDigit(s[left]) == Character.isLetterOrDigit(s[right]), if yes then left++ and right--,
// else return false;
// return true;

package Data_Structures.String.Easy;

// Optimal/Expected Solution
// Time: O(n), n [sb.append] + n [left/right on sb], n = s.length()
// Space: O(n), sb length == s length, n = s.length()
class Solution1 {
  public boolean sentencePalindrome(String s) {
    // StringBuilder sb = new StringBuilder(s.replaceAll("\\s+", ""));
    StringBuilder sb = new StringBuilder();

    for (char c : s.toLowerCase().toCharArray()) {
      if (('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z')) {
        sb.append(c);
      }
    }

    int left = 0, right = sb.length() - 1;
    while (left < right) {
      if (sb.charAt(left++) != sb.charAt(right--)) {
        return false;
      }
    }

    return true;
  }
}

// Optimal Solution with constant space
// Time: O(n), each char is visited once in loop, n = s.length()
// Space: O(1), left + right, constant time
class Solution2 {
  public boolean sentencePalindrome(String s) {
    int left = 0, right = s.length() - 1;

    while (left < right) {
      if (!Character.isLetterOrDigit(s.charAt(left))) {
        left++;
      } else if (!Character.isLetterOrDigit(s.charAt(right))) {
        right--;
      } else if (Character.toLowerCase(s.charAt(left)) == Character.toLowerCase(s.charAt(right))) {
        left++;
        right--;
      } else {
        return false;
      }
    }

    return true;
  }
}