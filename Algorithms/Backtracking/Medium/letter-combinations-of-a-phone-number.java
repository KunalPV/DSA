
// Hash Table, String, Backtracking

// create a static global final hashmap of DIGITS_TO_LETTER with digits map to relevant letters from a phone.
// create a list and check for digits length == 0 or digits is null, if yes then return the empty list, else backtrack(list, new StringBuilder(), digits, 0). And return the list at the end.
// backtrack(List<String> list, StringBuilder currStr, String digits, int index), get the digit character from the digits string using the index, then get the letters from the DIGITS_TO_LETTER with the digit character. check if letter is null, if yes then pass the same backtrack function with index + 1 and return.
// run a loop till letters.length(), append letters.charAt(i) to currStr, and call backtrack with index + 1, and after it remove the last character from currStr (BACKTRACKING) (currStr.deleteCharAt(currStr.length() - 1)).
// ** Bounding function here is if(index == digits.length()) then list.add(currStr.toString()) and then return;

package Algorithms.Backtracking.Medium;

import java.util.*;

class Solution {
  private final static HashMap<Character, String> DIGITS_TO_LETTER = new HashMap<>();

  static {
    DIGITS_TO_LETTER.put('2', "abc");
    DIGITS_TO_LETTER.put('3', "def");
    DIGITS_TO_LETTER.put('4', "ghi");
    DIGITS_TO_LETTER.put('5', "jkl");
    DIGITS_TO_LETTER.put('6', "mno");
    DIGITS_TO_LETTER.put('7', "pqrs");
    DIGITS_TO_LETTER.put('8', "tuv");
    DIGITS_TO_LETTER.put('9', "wxyz");
  }

  public List<String> letterCombinations(String digits) {
    List<String> list = new ArrayList<>();

    if (digits.length() == 0 || digits == null) {
      return list;
    }

    backtrack(list, new StringBuilder(), digits, 0);

    return list;
  }

  private void backtrack(List<String> list, StringBuilder currStr, String digits, int index) {
    // bounding function
    if (index == digits.length()) {
      list.add(currStr.toString());
      return;
    }

    char digit = digits.charAt(index);
    String letters = DIGITS_TO_LETTER.get(digit);

    if (letters == null) {
      backtrack(list, currStr, digits, index + 1);
      return;
    }

    for (int i = 0; i < letters.length(); i++) {
      currStr.append(letters.charAt(i));

      backtrack(list, currStr, digits, index + 1);

      currStr.deleteCharAt(currStr.length() - 1);
    }
  }
}