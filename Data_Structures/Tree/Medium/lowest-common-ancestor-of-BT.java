
// Tree, Binary Tree, DFS, Recursion

// ** check if root equals null or p or q, if yes return root,
// create TreeNode left and store lowestCommonAncestor(root.left, p, q),
// create TreeNode right and store lowestCommonAncestor(root.right, p, q),
// check if left == null, then return right;
// else if right == null, then return left;
// else return root;

package Data_Structures.Tree.Medium;

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

// Expected Solution: Recursive DFS
// Time: O(n), worst case: each node is visited once, n = num of nodes
// Space: O(h), Recursive call stack worst case: O(n) [skewed tree] and best
// case: O(logn) [balanced tree], h = height of the tree
class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) {
      return root;
    }

    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);

    if (left == null) {
      return right;
    } else if (right == null) {
      return left;
    } else {
      return root;
    }
  }
}
