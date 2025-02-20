
// Tree, Binary Tree, Breadth First Search, Queue
//
// create a Queue<TreeNode> queue and maxLevelSum, currLevel and maxSum as 0, 0 and Integer.MIN_VALUE,
// queue.offer(root),
// loop till NOT queue.isEmpty, create currSum and n as 0 and queue.size(),
// loop i = 0 till n, create TreeNode node as queue.poll(), currSum += node.val;
// check if i == n - 1, then currLevel++;
// check if node.left != null, then queue.offer(node.left),
// check if node.right != null, then queue.offer(node.right),
// check if currSum > maxSum, then maxSum = currSum and MaxLevelSum = currLevel;
// return maxLevelSum;
//
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

// Expected Solution: Breadth First Search using Queue
// Time: O(n), each node is processed once, n = num of nodes
// Space: O(l), worst case: O(n/2) -> O(n) [balanced tree: last level contains n/2 nodes] and best case: O(1) [skewed tree: 1 node at each level], l = nodes at each level
class Solution {

    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        int maxLevelSum = 0, currLevel = 0;
        int maxSum = Integer.MIN_VALUE;

        queue.offer(root);

        while (!queue.isEmpty()) {
            int currSum = 0;
            int n = queue.size();

            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                currSum += node.val;

                if (i == n - 1) {
                    currLevel++;
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            if (currSum > maxSum) {
                maxSum = currSum;
                maxLevelSum = currLevel;
            }
        }

        return maxLevelSum;
    }
}
