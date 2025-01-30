package Data_Structures.String.Easy;

import java.util.*;

// Good Solution, but can be optimized in terms of space.
// Time: O(n), n [s.toCharArray()] + n [hashmap, worst case: all unique elems in s] -> n, n = s.length()
// Space: O(n), worst case: all unique elems, n = HashMap length
class Solution1 {
  public int maxRepeating(String s) {
    int n = s.length();

    if (n == 0 || n == 1) {
      return n;
    }

    int maxRepeat = 0;

    Map<Character, Integer> map = new HashMap<>();

    for (char c : s.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }

    for (Map.Entry<Character, Integer> e : map.entrySet()) {
      if (e.getValue() > maxRepeat) {
        maxRepeat = e.getValue();
      }
    }

    return maxRepeat;
  }
}

class Solution2 {
  private static final int MAX_CHAR = 26;

  public int maxRepeating(String s) {
    int n = s.length();

    if (n == 0 || n == 1) {
      return n;
    }

    int maxRepeat = 0;
    int vis[] = new int[MAX_CHAR];

    Arrays.fill(vis, 0);

    for (char c : s.toCharArray()) {
      vis[c - 'a']++;
    }

    for (int num : vis) {
      if (num > maxRepeat) {
        maxRepeat = num;
      }
    }

    return maxRepeat;
  }
}
