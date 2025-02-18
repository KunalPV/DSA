
// Tree, Binary Tree, DFS, BFS, Queue, Recursion
//
// Solution 1: BFS using Queue
// create a ArrayList<Integer> list and Queue<TreeNode> queue, and queue.offer(root),
// loop till NOT queue.isEmpty, create n as queue.size(),
// loop i = 0 till n, create node as queue.poll(), check if(i == n - 1), then list.add(node.val), 
// // // [means we got the last elem of that level]
// check if(node.left != null), then queue.offer(node.left),
// check if(node.right != null), then queue.offer(node.right),
//
// Solution 2: Recursive DFS
// create a ArrayList<Integer> list, call dfs(root, list, 0),
// return list;
// ** void dfs(TreeNode root, List<Integer> list, int depth),
// ** if(root == null), return;
// check if(list.size() == depth), then list.add(root.val);
// check if(root.right != null), dfs(root.right, list, depth + 1), [always go right 1st and then left]
// check if(root.left != null), dfs(root.left, list, depth + 1),
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

// Optimal Solution: Breadth First Search using Queue
// Time: O(n), each node is processed once, n = num of nodes
// Space: O(n), worst case: Queue stores O(n/2) nodes [balanced tree] and list stores O(n) nodes [right sided skewed tree], n = num of nodes
class Solution1 {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            int n = queue.size();

            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();

                if (i == n - 1) {
                    list.add(node.val);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return list;
    }
}

// Optimal Solution: Recursive Depth First Search
// Time: O(n), each node is processed once, n = num of nodes
// Space: O(h), worst case: recursive call stack stores O(n) [skewed tree] and O(logn) [balanced tree], h = height of the tree
class Solution2 {

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> list = new ArrayList<>();

        dfs(root, list, 0);

        return list;
    }

    private void dfs(TreeNode root, List<Integer> list, int depth) {
        if (root == null) {
            return;
        }

        if (depth == list.size()) {
            list.add(root.val);
        }

        if (root.right != null) {
            dfs(root.right, list, depth + 1);
        }
        if (root.left != null) {
            dfs(root.left, list, depth + 1);
        }
    }
}
