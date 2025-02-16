
// Tree, Binary Tree, DFS, Recursion

// Solution 1: Recursive DFS
// return dfs(root, root.val, 0);

// ** int dfs(TreeNode root, int max, int count)
// ** check if(root == null), then return count;
// check if(root.val >= max), is yes count++ and update max to node.val,
// create left and store dfs(root.left, max, count),
// return dfs(root.right, max, left);

// Solution 2: BFS using Queue and custom Pair class,
// create a Queue<Pair<TreeNode, Integer>> queue and queue.offer(new Pair<>(root, root.val)),
// create count as 0,
// loop till NOT queue.isEmpty, 
// create Pair<TreeNode, Integer> pair as queue.poll(), node as pair.key, maxSoFar as pair.value,
// check if(node.val >= maxSoFar), if yes count++ and maxSoFar as node.val,
// check if(node.left != null), queue.offer(new Pair<>(root.left, maxSoFar)),
// check if(node.right != null), queue.offer(new Pair<>(root.right, maxSoFar)),
// return count;

// Overall Solution 1 is better than 2, because it uses low memory at each iteration.

package Data_Structures.Tree.Medium;

import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}

// Expected Solution: Recursive Depth First Search
// Time: O(n), each node is processed once, n = num of nodes
// Space: O(h), worst case: O(n) [skewed tree] and best case: O(logn) [balanced
// tree], h = height of the tree
class Solution1 {
  public int goodNodes(TreeNode root) {
    return dfs(root, root.val, 0);
  }

  private int dfs(TreeNode root, int max, int count) {
    if (root == null) {
      return count;
    }

    if (root.val >= max) {
      count++;
      max = root.val;
    }

    int left = dfs(root.left, max, count);
    return dfs(root.right, max, left);
  }
}

class Pair<K, V> {
  K key;
  V value;

  Pair(K key, V value) {
    this.key = key;
    this.value = value;
  }
}

// Optimal Solution: Breadth First Search using Queue
// Time: O(n), each node is visited once, n = num of nodes
// Space: O(n), worst case: O(n) [balanced tree: max num nodes = n/2 -> n] and
// best case: O(1) [skewed tree: stores only O(1) node at a time], n = num of
// nodes
class Solution2 {
  public int goodNodes(TreeNode root) {
    if (root == null) {
      return 0;
    }

    Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
    queue.offer(new Pair<>(root, root.val));

    int count = 0;

    while (!queue.isEmpty()) {
      Pair<TreeNode, Integer> pair = queue.poll();
      TreeNode node = pair.key;
      int maxSoFar = pair.value;

      if (node.val > maxSoFar) {
        count++;
        maxSoFar = node.val;
      }

      if (node.left != null) {
        queue.offer(new Pair<>(root.left, maxSoFar));
      }
      if (node.right != null) {
        queue.offer(new Pair<>(root.right, maxSoFar));
      }
    }

    return count;
  }
}