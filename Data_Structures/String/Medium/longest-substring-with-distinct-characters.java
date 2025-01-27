
// String, Two-Pointers

// create result as 0, vis bool array of 26 size, left and right as 0,
// loop till right < n, check if vis[s.charAt(right) - 'a'] is true,
// if yes then set vis[s.charAt(left) - 'a'] to false, and increment left by 1,
// set vis[s.charAt(right) - 'a'] to true, and calculate res from max(res, right - left + 1),
// return result;

package Data_Structures.String.Medium;

// Optimal Solution
// Time: O(n), worst case: left + right traverse s exactly once, n = s.length()
// Space: O(1), O(26) + result + left + right -> O(1) [auxilary space]
class Solution {
  static final int MAX_CHAR = 26;

  public int longestUniqueSubStr(String s) {
    int n = s.length();

    if (n == 0 || n == 1) {
      return n;
    }

    boolean vis[] = new boolean[MAX_CHAR];
    int result = 0;

    int left = 0, right = 0;
    while (right < n) {
      if (vis[s.charAt(right) - 'a'] == true) {
        vis[s.charAt(left) - 'a'] = false;
        left++;
      }

      vis[s.charAt(right) - 'a'] = true;

      result = Math.max(result, right - left + 1);
      right++;
    }

    return result;
  }
}
