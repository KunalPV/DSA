
// Hash Table, Depth-First Search, Breadth-First Search, Graph

// check is node is null and return null if true, create a new node copy with the given node.val, and also create a 101 array of Node. (1 <= Node.val <= 100). Fill the array with null value with Arrays.fill(vis, null)
// call dfs(node, copy, vis[]) and return copy
// In dfs(node, copy, vis[]), set vis[copy.val] = copy
// ** neighbors is a list of node, so all list functions works such as 'add' method.
// run a for each loop on node.neighbors with n, if (vis[n.val] == null) then create a newNode with n.val, add this to copy.neighbors (copy.neighbors.add(newNode)) and call dfs(n, newNode, vis[]) again recursively
// else (copy.neighbors.add(vis[n.val]))  // vis[n.val] returns Node n.

import java.util.*;

class Node {
  public int val;
  public List<Node> neighbors;

  public Node() {
    val = 0;
    neighbors = new ArrayList<Node>();
  }

  public Node(int _val) {
    val = _val;
    neighbors = new ArrayList<Node>();
  }

  public Node(int _val, ArrayList<Node> _neighbors) {
    val = _val;
    neighbors = _neighbors;
  }
}

class Solution {
  public Node cloneGraph(Node node) {
    if (node == null)
      return null;

    Node copy = new Node(node.val);
    Node vis[] = new Node[101]; // 1 <= Node.val <= 100
    Arrays.fill(vis, null);

    dfs(node, copy, vis);

    return copy;
  }

  private void dfs(Node node, Node copy, Node vis[]) {
    vis[copy.val] = copy;

    for (Node n : node.neighbors) {
      if (vis[n.val] == null) {
        Node newNode = new Node(n.val);

        copy.neighbors.add(newNode);
        dfs(n, newNode, vis);
      } else {
        copy.neighbors.add(vis[n.val]);
      }
    }
  }
}