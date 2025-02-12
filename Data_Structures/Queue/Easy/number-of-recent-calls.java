
// Queue

// create a Queue<Integer> q,
// assign it to linkedlist in the constructor function, q = new LinkedList<>();
// in ping(int t) func, add t to q [q.add(t)], 
// loop till q.peek() < t - 3000, if yes, then q.poll(),
// return q.size();

package Data_Structures.Queue.Easy;

import java.util.*;

// Expected Solution
// Time: O(1), add [constant time] + while loop [constant time], constant time
// Space: O(n), worst case each ping input t will be more 3000 more than previous, n = number of pings in a 3000ms window
class RecentCounter {
  private static final int TIME_RANGE = 3000;
  Queue<Integer> q;

  public RecentCounter() {
    q = new LinkedList<>();
  }

  public int ping(int t) {
    q.add(t);
    while (q.peek() < t - TIME_RANGE) {
      q.poll();
    }

    return q.size();
  }
}
