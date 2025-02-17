
// Tree, Binary Tree, DFS
//
// create a HashMap<Integer, Integer> map and map.put(0, 1),
// return backtrack(root, 0, targetSum, map);
// ** int backtrack(TreeNode root, int current, int targetSum, Map<Integer, Integer> map),
// ** if(root == null) then return 0;
// create count as 0, and assign current + root.val to current,
// assign map.getOrDefault(current - targetSum, 0) to count,
// put(current, map.getOrDefault(current, 0) + 1) to the map,
// count += backtrack(root.left, current, targetSum, map),
// count += backtrack(root.right, current, targetSum, map),
// ** backtracking -> map.put(current, map.get(current) - 1);
// return count;
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

// Optimal Solution: DFS Backtracking
// Time: O(n), each node is processed once, n = num of nodes
// Space: O(h + n), recursive call stack -> worst case: O(n) [skewed tree] and best case: O(logn) [balanced tree] + O(n) [worst case: hashmap can store upto N prefix sum], n = num of nodes and h = height of tree
class Solution {

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        return backtrack(root, 0, targetSum, map);
    }

    private int backtrack(TreeNode root, int current, int targetSum, Map<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }

        int count = 0;
        current += root.val;

        count += map.getOrDefault(current - targetSum, 0);
        map.put(current, map.getOrDefault(current, 0) + 1);

        count += backtrack(root.left, current, targetSum, map);
        count += backtrack(root.right, current, targetSum, map);

        map.put(current, map.get(current) - 1);

        return count;
    }
}
