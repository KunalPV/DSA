// Tree, Binary Tree, Array, Divide and Conquer

// write and helper function which calls itself recursively
// postorder is left-right-root and inorder is left-root-right
// helper function takes inorder, inStart, inEnd, postorder, postStart and postEnd
// check and return null if inStart > inEnd or postStart > postEnd
// create a new TreeNode with postorder[postEnd] as value, as last elem in postorder is the root
// check that elem in inorder and get the index as rootIndex
// call helper on left of root (root.left) with inorder, inStart, rootIndex - 1, postorder, postStart, postStart + (rootIndex - inStart) - 1;
// call helper on right of root (root.right) with inorder, rootIndex + 1, inEnd, postorder, postEnd - (inEnd - rootIndex), postEnd - 1;
// return root

// Definition for a binary tree node.
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

class Solution {
  public TreeNode buildTree(int[] inorder, int[] postorder) {
    return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
  }

  public TreeNode helper(int inorder[], int inStart, int inEnd, int postorder[], int postStart, int postEnd) {
    if (inStart > inEnd || postStart > postEnd) {
      return null;
    }

    int rootVal = postorder[postEnd];
    TreeNode root = new TreeNode(rootVal);

    int rootIndex = 0;
    for (int i = inStart; i <= inEnd; i++) {
      if (inorder[i] == root.val) {
        rootIndex = i;
        break;
      }
    }

    int leftSize = rootIndex - inStart;
    int rightSize = inEnd - rootIndex;

    root.left = helper(inorder, inStart, rootIndex - 1, postorder, postStart, postStart + leftSize - 1);
    root.right = helper(inorder, rootIndex + 1, inEnd, postorder, postEnd - rightSize, postEnd - 1);

    return root;
  }
}