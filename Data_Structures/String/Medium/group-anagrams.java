import java.util.*;

// Create a Hashmap of <String, List<String>>
// Sort each string from the array and store the sorted-string as key and sort the unsorted-string in value (String ArrayList)
// repeat and check if map contains the key and add the value to the String ArrayList

class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
    int n = strs.length;

    HashMap<String, List<String>> map = new HashMap<>();

    for (int i = 0; i < n; i++) {
      char ch[] = strs[i].toCharArray();
      Arrays.sort(ch);
      String sortedStr = new String(ch);

      if (!map.containsKey(sortedStr)) {
        map.put(sortedStr, new ArrayList<>());
      }

      map.get(sortedStr).add(strs[i]);
    }

    return new ArrayList<>(map.values());
  }
}