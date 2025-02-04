
// String, HashMap, Frequency Array

// Solution 1: good time and good space
// create a map of <char, int>, loop 0 till m, and store or increment s1.charAt(i) as 1 or val++,
// loop 0 till n, and decrement map.get(s2.charAt(i)),
// loop through map [entrySet()], check if e.getValue() != 0, if yes then return false;
// return true;

// Solution 2: good time and great space
// create a freq counter array vis[26], loop 0 till m, vis[s1.charAt(i) - 'a']++;
// loop 0 till n, vis[s2.charAt(i) - 'a']--;
// loop vis array, check if vis[i] != 0, if yes then return false;
// return true;

package Data_Structures.String.Easy;

import java.util.*;

// Better Approach
// Time: O(n), O(m) [s1.length] + O(n) [s2.length], n = s1.length || s2.length
// Space: O(n), worst case -> all distinct elems in s1, so s1 size == map size , n = s1.length
class Solution1 {
  public boolean areAnagram(String s1, String s2) {
    int m = s1.length(), n = s2.length();
    if (m != n) {
      return false;
    }

    Map<Character, Integer> map = new HashMap<>();

    for (int i = 0; i < m; i++) {
      map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
    }

    for (int i = 0; i < n; i++) {
      map.put(s2.charAt(i), map.getOrDefault(s2.charAt(i), 0) - 1);
    }

    for (Map.Entry<Character, Integer> e : map.entrySet()) {
      if (e.getValue() != 0) {
        return false;
      }
    }

    return true;
  }
}

// Optimal Solution
// Time: O(n), m [s1 size]+ n [s2 size]+ vis [26] -> n, n = s1 size || s2 size
// Space: O(1), vis [26 size], constant size
class Solution2 {
  private static final int MAX_CHAR = 26;

  public boolean areAnagram(String s1, String s2) {
    int m = s1.length(), n = s2.length();
    if (m != n) {
      return false;
    }

    int vis[] = new int[MAX_CHAR];

    for (int i = 0; i < m; i++) {
      vis[s1.charAt(i) - 'a']++;
    }

    for (int i = 0; i < n; i++) {
      vis[s2.charAt(i) - 'a']--;
    }

    for (int count : vis) {
      if (count != 0) {
        return false;
      }
    }

    return true;
  }
}