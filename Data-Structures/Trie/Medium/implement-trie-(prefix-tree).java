
// Hash Table, String, Design, Trie

class Trie {
  class Node {
    Node[] children;
    boolean eow;

    Node() {
      children = new Node[26];
      this.eow = false;
    }
  }

  Node root;

  public Trie() {
    root = new Node();
  }

  public void insert(String word) {
    insertHelper(word);
  }

  public boolean search(String key) {
    return searchHelper(key);
  }

  public boolean startsWith(String prefix) {
    return startsWithHelper(prefix);
  }

  private void insertHelper(String word) {
    Node curr = root;
    for (int i = 0; i < word.length(); i++) {
      int idx = word.charAt(i) - 'a';

      if (curr.children[idx] == null) {
        curr.children[idx] = new Node();
      }

      if (i == word.length() - 1) {
        curr.children[idx].eow = true;
      }

      curr = curr.children[idx];
    }
  }

  private boolean searchHelper(String key) {
    Node curr = root;

    for (int i = 0; i < key.length(); i++) {
      int idx = key.charAt(i) - 'a';

      if (curr.children[idx] == null) {
        return false;
      }

      if (i == key.length() - 1 && curr.children[idx].eow == false) {
        return false;
      }

      curr = curr.children[idx];
    }

    return true;
  }

  private boolean startsWithHelper(String prefix) {
    Node curr = root;

    for (int i = 0; i < prefix.length(); i++) {
      int idx = prefix.charAt(i) - 'a';

      if (curr.children[idx] == null) {
        return false;
      }

      curr = curr.children[idx];
    }

    return true;
  }
}