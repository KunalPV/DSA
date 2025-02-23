
// Graph, DFS, Array, Adjacency List
// create a List<List<Integer>> adjList,
// loop i = 0 till n, adjList.add(new ArrayList<>()), [initialize the list of list with empty array-list]
// loop int[] c through connections, adjList.get(c[0]).add(c[1]) and adjList.get(c[1]).add(-c[0]), // c = [0, 1] => { {0, 1}, {1, -0} }
// return dfs(adjList, new boolean[n], 0);
//
// ** int dfs(List<List<Integer>> adjList, boolean vis[], int from),
// create change as 0, and vis[from] = true,
// loop int to through adjList.get(from),
// check if NOT vis[Math.abs(to)], 
// then change += dfs(adjList, vis, Math.abs(to)) + (to > 0 ? 1 : 0),
// return change;
//
import java.util.*;

// Expected Solution: using Adjacency List and vis array
// Time: O(n), O(n) [int[][] -> List<List<Integer>>] + O(n) [dfs: each node is visited once + at each node we traverse all its neighbors from adjList] -> O(n), n = number of cities/connections
// Space: O(n), O(n) [adjList] + O(n) [vis[]] + O(n) [worst case: recursive call stack stores n elem: skewed tree] -> O(n), n = num of cities/connections
class Solution {

    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] c : connections) {
            adjList.get(c[0]).add(c[1]);
            adjList.get(c[1]).add(-c[0]);
        }

        return dfs(adjList, new boolean[n], 0);
    }

    private int dfs(List<List<Integer>> adjList, boolean vis[], int from) {
        int change = 0;
        vis[from] = true;

        for (int to : adjList.get(from)) {
            if (!vis[Math.abs(to)]) {
                change += dfs(adjList, vis, Math.abs(to)) + (to > 0 ? 1 : 0);
            }
        }

        return change;
    }
}
