
// Tree, Binary Tree, Binary Search Tree, Recursion, Depth First Search
//
// Solution 1: Recursive DFS
// ** check if root == null, if yes return null,
// check if root.val == val, if yes return root;
// else return (val < root.val) ? searchBST(root.left, val) : searchBST(root.right, val)
//
// Solution 2: Iterative DFS
// loop till root NOT equals null and root.val NOT equals val,
// root = (val < root.val) ? root.left : root.right;
// return root;
//
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

// Recursive Depth First Search
// Time: O(h), worst case: O(n) [skewed tree: each node is processed], avg case: O(logn) [balanced tree: left/right part is choosen] and best case: O(1) [root.val == val], h = height of tree
// Space: O(h), recursive call stack worst case: O(n) [skewed tree], O(logn) [balanced tree] and O(1) [root.val == val], h = height of tree
class Solution1 {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (val == root.val) {
            return root;
        } else {
            return (val < root.val) ? searchBST(root.left, val) : searchBST(root.right, val);
        }
    }
}

// Iterative Depth First Search
// Time: O(h), worst case: O(n) [skewed tree: each node is processed], avg case: O(logn) [balanced tree: left/right part is choosen] and best case: O(1) [root.val == val], h = height of tree
// Space: O(1), no space is used, just root pointer is changed in each iteration
class Solution2 {

    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null && root.val != val) {
            root = (val < root.val) ? root.left : root.right;
        }

        return root;
    }
}
