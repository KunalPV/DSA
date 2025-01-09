
// Array, Divide and Conquer, Tree, Binary Search Tree, Binary Tree

// create a divideAndConquer(nums, 0, nums.length - 1) helper function which runs recursively and returns node (returns null if there's nothing),and makes a binary search tree and return it in main function.
// in divideAndConquer(int nums[], int low, int high), take out the mid from low and high by (low + ((high - low) / 2)), and create a newNode TreeNode with nums[mid] as val, and for newNode.left and newNode.right, assign the divideAndConquer(nums, low, mid - 1) and divideAndConquer(nums, mid + 1, high) and return the newNode at the end.
// ** bounding function here is, when low > high then return null;

package Algorithms.Divide_And_Conquer.Easy;

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
  public TreeNode sortedArrayToBST(int[] nums) {
    return divideAndConquer(nums, 0, nums.length - 1);
  }

  private TreeNode divideAndConquer(int nums[], int low, int high) {
    if (low > high) {
      return null;
    }

    int mid = low + ((high - low) / 2);

    TreeNode newNode = new TreeNode(nums[mid]);

    newNode.left = divideAndConquer(nums, low, mid - 1);
    newNode.right = divideAndConquer(nums, mid + 1, high);

    return newNode;
  }
}
