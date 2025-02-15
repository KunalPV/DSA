
// Tree, Binary Tree, DFS, Stack, Recursion

// Solution 1: Recursive DFS
// create 2 list, list1 and list2,
// call dfs(root1, list1) and dfs(root2, list2),
// return list1.equals(list2),

// ** void dfs(TreeNode root, List<Integer> list),
// ** if(root == null), then return;
// check if(root.left == null and root.right == null), then list.add(root.val);
// call dfs(root.left, list) and dfs(root.right, list),

// Solution 2: Iterative DFS using Stack
// create 2 Stack<TreeNode> s1 and s2,
// loop till NOT s1.isEmpty and NOT s2.isEmpty,
// check if (dfs(s1) != dfs(s2)), then return false;
// return s1.isEmpty() && s2.isEmpty();

// ** int dfs(Stack<TreeNode> s),
// loop till true, 
// create TreeNode node and store s.pop(),
// check if node.right != null, then s.push(node.right);
// check if node.left != null, then s.push(node.left);
// check if node.left == null && node.right == null, then return node.val;

package Data_Structures.Tree.Easy;

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

// Optimal Solution: Recursive Depth First Search

// Time: O(n1 + n2), each node is visited once in both n1 and n2 -> n1 + n2, n1
// = num of nodes in root1 and n2 = num of nodes in root2,

// Space: O(l1 + l2 + h), list1 + list2 + height [worst case: O(n) [skewed tree]
// and best case: O(logn) [balanced tree]] -> l1 + l2 + n1 + n2 [worst case] or
// l1 + l2 + logn1 + logn2 [best case], l1 = list1.size and l2 = list2.size and
// h = recursion depth
class Solution1 {
  public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();

    dfs(root1, list1);
    dfs(root2, list2);

    return list1.equals(list2);
  }

  private void dfs(TreeNode root, List<Integer> list) {
    if (root == null) {
      return;
    }

    if (root.left == null && root.right == null) {
      list.add(root.val);
      return;
    }

    dfs(root.left, list);
    dfs(root.right, list);
  }
}

// Optimal Solution: Iterative Depth First Search using Stack
// Time: O(n1 + n2), each node in both trees is visited once, n1 = roo1 num of
// nodes and n2 = root2 num of nodes
// Space: O(h1 + h2), worst case: O(n1 + n2) [skewed tree] and best case:
// O(logn1 + logn2) [balanced tree], h1 = height of root1 and h2 = height of
// root2
class Solution2 {
  public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    Stack<TreeNode> s1 = new Stack<>(), s2 = new Stack<>();
    s1.push(root1);
    s2.push(root2);

    while (!s1.isEmpty() && !s2.isEmpty()) {
      if (dfs(s1) != dfs(s2)) {
        return false;
      }
    }

    return s1.isEmpty() && s2.isEmpty();
  }

  private int dfs(Stack<TreeNode> s) {
    while (true) {
      TreeNode node = s.pop();

      if (node.right != null) {
        s.push(node.right);
      }
      if (node.left != null) {
        s.push(node.left);
      }
      if (node.left == null && node.right == null) {
        return node.val;
      }
    }
  }
}