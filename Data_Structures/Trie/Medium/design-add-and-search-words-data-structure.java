
// String, Depth-First Search, Design, Trie

// create a children array with 26 size and a bool val eow and instantiate it with the constructor
// in addWord func, create a curr variable with WordDictionary as its datatype, loop through the given word, if the character of the word is not in the curr.children[c - 'a'] then instantiate a new WordDictionary class to that index. set curr = curr.children[c - 'a'] and at last if it is at the last character from the word
// in searchWord func, create a curr variable with WordDictionary as its datatype, through the given word, if c == '.' then run a nested loop inside (WordDictionary ch : curr.children), check if ch != null and ch(word.substring(i + 1)), then return true, else false.
// check if curr.children[c - 'a'] == null and return false, update curr to curr.children[c - 'a'], and finally at the end return curr != null && curr.eow

class WordDictionary {
  private WordDictionary[] children;
  boolean eow;

  public WordDictionary() {
    children = new WordDictionary[26];
    this.eow = false;
  }

  public void addWords(String word) {
    WordDictionary curr = this;

    for (char c : word.toCharArray()) {
      if (curr.children[c - 'a'] == null) {
        curr.children[c - 'a'] = new WordDictionary();
      }

      curr = curr.children[c - 'a'];
    }

    curr.eow = true;
  }

  public boolean search(String word) {
    WordDictionary curr = this;

    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);

      if (c == '.') {
        for (WordDictionary ch : curr.children) {
          if (ch != null && ch.search(word.substring(i + 1))) {
            return true;
          }
        }

        return false;
      }

      if (curr.children[c - 'a'] == null) {
        return false;
      }

      curr = curr.children[c - 'a'];
    }

    return curr != null && curr.eow;
  }
}