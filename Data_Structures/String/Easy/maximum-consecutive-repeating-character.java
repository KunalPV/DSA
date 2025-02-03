
// String, Counter

// create count, currCount and result as 0, 0 and s.charAt(0), 
// loop 0 till n, check if i < n - 1 and s[i] == s[i + 1], if yes then increment currCount,
// else, check if currCount > count, if yes then set count = currCount and result = s[i],
// and set currCount to 1,
// return result;

package Data_Structures.String.Easy;

// Optimal Solution
// Time: O(n), each char is visited once in s, n = s.length()
// Space: O(1), count + currCount + result + n -> 1, constant time
class Solution1 {
  public char maxRepeating(String s) {
    int n = s.length();

    if (n == 1) {
      return s.charAt(n);
    }

    int count = 0, currCount = 0;
    char result = s.charAt(0);
    for (int i = 0; i < n; i++) {
      if (i < n - 1 && s.charAt(i) == s.charAt(i + 1)) {
        currCount++;
      } else {

        if (currCount > count) {
          count = currCount;
          result = s.charAt(i);
        }

        currCount = 1;
      }
    }

    return result;
  }
}