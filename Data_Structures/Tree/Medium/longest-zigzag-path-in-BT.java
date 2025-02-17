
// Tree, Binary Tree, Depth First Search, Recursion

// create a global variable, maxStep as 0,
// run dfs(root, true, 0),
// return maxStep;
// ** void dfs(TreeNode root, boolean isLeft, int step),
// ** if(root == null), return;
// assign max(maxStep, step) to maxStep,
// else dfs(root.right, true, step + 1) and dfs(root.left, false, 1),

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

// Optimal Solution: Recursive Depth First Search
// Time: O(n), each node is processed once, n = num of nodes
// Space: O(h), recursive call stack -> worst case: O(n) [skewed tree: call stack = num of nodes] and best case: O(logn) [balanced tree: call stack = log(num of nodes)] -> O(n), h = height of the tree
class Solution {

    private int maxStep = 0;

    public int longestZigZag(TreeNode root) {
        dfs(root, true, 0);

        return maxStep;

    }

    private void dfs(TreeNode root, boolean isLeft, int step) {
        if (root == null) {
            return;
        }

        maxStep = Math.max(maxStep, step);

        if (isLeft) {
            dfs(root.left, false, step + 1);
            dfs(root.right, true, 1);
        } else {
            dfs(root.right, true, step + 1);
            dfs(root.left, false, 1);
        }
    }
}
