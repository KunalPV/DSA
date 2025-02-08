
// String, Sorting, Frequency counter

// create two frequency arrays, freq1 and freq2 of size 26,
// loop through word1 and word2 and increment the freq1[c - 'a] and freq2[c - 'a']
// loop 0 till 26, check if freq1[i] == freq2[i], if yes then continue,
// check if freq1[i] or freq2[i] equals 0, if yes then return false;
// sort both the arrays freq1 and freq2
// can just return Arrays.equals(freq1, freq2);

// or loop 0 till 26, check freq1[i] != freq2[i], if yes return false;
// return true;

package Data_Structures.String.Medium;

import java.util.*;

// Optimal Solution
// Time: O(n), n [word1] + n [word2] + 1 [sort of 26 is constant time], n = word1 or word2 length
// Space: O(1), 26 [freq1] + 26 [freq2], constant space
class Solution {
  private static final int MAX_CHAR = 26;

  public boolean closeStrings(String word1, String word2) {
    if (word1.length() != word2.length()) {
      return false;
    }

    int freq1[] = new int[MAX_CHAR];
    int freq2[] = new int[MAX_CHAR];

    for (char c : word1.toCharArray()) {
      freq1[c - 'a']++;
    }

    for (char c : word2.toCharArray()) {
      freq2[c - 'a']++;
    }

    for (int i = 0; i < MAX_CHAR; i++) {
      if (freq1[i] == freq2[i]) {
        continue;
      }

      if (freq1[i] == 0 || freq2[i] == 0) {
        return false;
      }
    }

    Arrays.sort(freq1);
    Arrays.sort(freq2);

    // for (int i = 0; i < MAX_CHAR; i++) {
    // if (freq1[i] != freq2[i]) {
    // return false;
    // }
    // }
    // return true;

    return Arrays.equals(freq1, freq2);
  }
}
