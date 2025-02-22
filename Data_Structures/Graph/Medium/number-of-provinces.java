
// Graph, Array, DFS, Recursion
// create a int vis array of size isConnected.length, and count as 0,
// loop i = 0 till n, check if(vis[i] == 0), if yes call dfs(isConnected, vis, i), and increment count by one,
// return count;
//
// ** void dfs(int[][] isConnected, int[] vis, int i),
// loop j = 0 till isConnected.length, 
// check if(isConnected[i][j] == 1 && vis[j] == 0), 
// if yes vis[j] = 1 and call dfs(isConnected, vis, j),
//
// Expected Solution: DFS using a visited array
// Time: O(n^2), O(n) [outer loop] * O(n) [each edge/neighbour is visited in worst case] -> O(n^2), n = length of isConnected
// Space: O(n), O(n) [vis array] + O(n) [recursive call stack] -> O(n), n = len of vis array/isConnected
class Solution {

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        int vis[] = new int[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                dfs(isConnected, vis, i);
                count++;
            }
        }

        return count;
    }

    private void dfs(int[][] isConnected, int[] vis, int i) {
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && vis[j] == 0) {
                vis[j] = 1;
                dfs(isConnected, vis, j);
            }
        }
    }
}
