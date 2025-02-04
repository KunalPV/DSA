
// String, Array, HashMap, ArrayList

// create a result list of list and map<integer, list of string>,
// loop through s, create a temp var called val as 0, 
// loop through str.toCharArray(), val = val + c
// check is map contains val, if yes then get the val from map and add the str to that list,
// else, create an arraylist and add str to that list and add val and list to map,
// loop through map.entrySet(), result.add(e.getValue())
// return result;

package Data_Structures.String.Medium;

import java.util.*;

// Optimal Approach
// Time: O(n * k), n = s.length and k = max length of a elem in s[]
// Space: O(n * k)
class Solution {
  public List<List<String>> printAnagrams(String s[]) {
    List<List<String>> result = new ArrayList<>();
    Map<Integer, List<String>> map = new HashMap<>();

    for (String str : s) {
      int val = 0;
      for (char c : str.toCharArray()) {
        val = val + c;
      }

      if (map.containsKey(val)) {
        map.get(val).add(str);
      } else {
        List<String> list = new ArrayList<>();
        list.add(str);
        map.put(val, list);
      }
    }

    for (Map.Entry<Integer, List<String>> e : map.entrySet()) {
      result.add(e.getValue());
    }

    return result;
  }
}
