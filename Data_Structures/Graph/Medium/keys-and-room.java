
// Graph, Recursion, Depth First Search
//
// create a bool array vis[] as size = rooms.size(),
// call dfs(rooms.get(0), 0, rooms, vis),
// loop v through vis, check if NOT v, if yes return false,
// return true;
//
// ** void dfs(List<Integer> keysInRoom, int room, List<List<Integer>> rooms, boolean vis[]),
// set vis[room] to true,
// loop i through keysInRoom,
// check if(!vis[i]), if yes dfs(rooms.get(i), i, rooms, vis)
//
import java.util.*;

// Expected Solution: DFS using a visited array
// Time: O(n + e), worst case each room from rooms (n) and each key/edge is traversed once, n = num of rooms and e = num of keys/edges
// Space: O(n), O(n) [vis array to keep track of all rooms] + O(n) [worst case: recursion call stack can go upto n rooms] -> O(n), n = vis[] or dfs recursion depth
class Solution {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();

        boolean vis[] = new boolean[n];

        dfs(rooms.get(0), 0, rooms, vis);

        for (boolean v : vis) {
            if (!v) {
                return false;
            }
        }

        return true;
    }

    private void dfs(List<Integer> keysInRoom, int room, List<List<Integer>> rooms, boolean vis[]) {
        vis[room] = true;

        for (int i : keysInRoom) {
            if (!vis[i]) {
                dfs(rooms.get(i), i, rooms, vis);
            }
        }
    }
}
