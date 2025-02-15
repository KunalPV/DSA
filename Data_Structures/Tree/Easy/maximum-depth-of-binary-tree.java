
// Tree, Binary Tree, DFS, Stack, BFS, Queue, Recurison

// Solution 1: DFS using stack
// create 2 stacks Stack<TreeNode> stack and Stack<Integer> value,
// push root to stack, create max as 0,
// loop till NOT queue.isEmpty pop from stack and queue and store in node and temp,
// calc Math.max(max, temp) and store in max,
// check if node.right NOT equals to null, push node.right and temp+1 to stack and value
// check if node.left NOT equals to null, push node.left and temp+1 to stack and value
// return max;

// Solution 2: BFS using queue
// create a Queue<TreeNode> queue, count as 0,
// offer(root) to queue, loop till NOT queue.isEmpty,
// store queue.size() in size, loop till size-- > 0,
// store queue.poll() in node,
// check if(node.left NOT equals null), queue.offer(node.left),
// check if(node.right NOT equals null), queue.offer(node.right),
// increment the count,
// return count;

// Solution 3: Recursive Depth First Search
// ** check if(root == null), if yes return 0,
// create depth = max(maxDepth(node.left), maxDepth(node.right)),
// return 1 + depth;

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

// Iterative Solution: Expect this method to implement 1st // DFS using stack
// Time: O(n), each node is visited once, n = number of nodes
// Space: O(n), worst case: O(n) [skewed tree] and best case: O(logn) [balanced
// tree] -> n, n = number of nodes
class Solution1 {
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    Stack<TreeNode> stack = new Stack<>();
    Stack<Integer> value = new Stack<>();

    stack.push(root);
    value.push(1);

    int max = 0;

    while (!stack.isEmpty()) {
      TreeNode node = stack.pop();
      int temp = value.pop();

      max = Math.max(max, temp);

      if (node.right != null) {
        stack.push(node.right);
        value.push(temp + 1);
      }

      if (node.left != null) {
        stack.push(node.left);
        value.push(temp + 1);
      }
    }

    return max;
  }
}

// Level-order traversal (BFS) using queue
// Iterative Solution: Also Expect this method to implement at 1st
// Time: O(n), each node is visited once, n = number of nodes
// Space: O(n), worst case: O(n/2) [last level] -> O(n) [balanced tree] and best
// case: O(1) [skewed tree, store only 1 node at each level] -> n, n = number of
// nodes
class Solution2 {
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    int count = 0;

    queue.offer(root);

    while (!queue.isEmpty()) {
      int size = queue.size();

      while (size-- > 0) {
        TreeNode node = queue.poll();

        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }
      }
      count++;
    }

    return count;
  }
}

// Recursive Solution: Recursive Depth First Search
// Time: O(n), each node is visited once and 2 calls for each node[left, right],
// n = number of nodes
// Space: O(n), worst case: O(n) [skewed tree, call stack = number of nodes] and
// best case: O(1) [balanced tree] -> n, n = number of nodes
class Solution3 {
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int depth = Math.max(maxDepth(root.left), maxDepth(root.right));

    return 1 + depth;
  }
}