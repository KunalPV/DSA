
// Graph, Depth-First Search, Breadth-First Search, Topological Sort

// first create a adj List to store the prerequisites for a single course, and create a preReq counter array to store the preRequisties a course needs, (index is same as the course), and also create an ArrayList to store ans.
// first loop through the prerequistes matrix(array of array), get the int[] pair, where pair[0] is the course, pair[1] is the prerequisite for the course. Add the course in the adj[prerequisite] array. And make the preReq counter array of course to increment by 1. (preReqCounter[course]++;)
// create a queue, loop through the preReq counter array and add the index to the queue if the preReqCounter[i] == 0.
// next run a loop till queue is empty, first poll the queue and store the polled elem in a variable current. Add this current to the ans ArrayList.
// in that same loop, check if adj[current] is null, if not then loop through adj[current], for each next got from adj[current], preReqCounter[next]--; , and if preReqCounter == 0, then queue.offer(next);
// finally return the ans.size() == n, if its true, then no cycle detected, hence can finish all the courses, if false, then cycle detected.

import java.util.*;

class Solution {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    int n = numCourses;
    List<Integer> adj[] = new List[n];
    int preReqCount[] = new int[n];
    List<Integer> ans = new ArrayList<>();

    for (int pair[] : prerequisites) {
      int course = pair[0];
      int prerequisite = pair[1];

      if (adj[prerequisite] == null) {
        adj[prerequisite] = new ArrayList<>();
      }

      adj[prerequisite].add(course);
      preReqCount[course]++;
    }

    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      if (preReqCount[i] == 0) {
        q.offer(i);
      }
    }

    while (!q.isEmpty()) {
      int curr = q.poll();
      ans.add(curr);

      if (adj[curr] != null) {
        for (int next : adj[curr]) {
          preReqCount[next]--;

          if (preReqCount[next] == 0) {
            q.offer(next);
          }
        }
      }
    }

    return ans.size() == n;
  }
}