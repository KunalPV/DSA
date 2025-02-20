//
// Tree, Binary Tree, Binary Search tree, Depth First Search, Recursion
//
// ** check if(root == null), if yes return null;
// check if key < root.val, if yes root.left = deleteNode(root.left, key)
// else if key > root.val, if yes root.right = deleteNode(root.right, key)
// else, check if root.left == null, then return root.right;
// check if root.right == null, then return root.left;
// create a TreeNode minNode and store findMin(root.right),
// set root.val = minNode.val,
// root.right = deleteNode(root.right, root.val),
// return root;
//
// ** TreeNode findMin(TreeNode node),
// loop till node.left != null, node = node.left,
// return node;

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
// Time: O(h), h [find the node to delete] + h [find the minimum node in right subtree] and [delete the min node] -> 2h, h = height of tree [O(n) -> skewed tree, O(logn) -> balanced tree]
// Space: O(h), recursive call stack in worst case: O(n) [skewed tree] and best case: O(logn) [balanced tree], h = height of tree
class Solution {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            TreeNode minNode = findMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, root.val);
        }

        return root;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }

        return node;
    }
}
