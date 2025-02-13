
// Queue, String, Greedy

// creates 2 Queue<Integer> rad and dir, and i as 0,
// loop ch through senate.toCharArray(), 
// check if ch == 'R', if yes rad.offer(i++), else dir.offer(i++),
// loop till NOT rad.isEmpty and NOT dir.isEmpty, 
// check if rad.poll() < dir.poll(), if yes rad.offer(i++), else dir.offer(i++),
// return !rad.isEmpty() ? "Radiant" : "Dire";

package Data_Structures.Queue.Medium;

import java.util.*;

// Expected Solution
// Time: O(n), n [each char in senate once] + n [every senator is enqueued and dequeued once] -> n, n = senate.length()
// Space: O(n), n [2 queues each storing at most n senators], n = senate.length()
class Solution {
  public String predictPartyVictory(String senate) {
    Queue<Integer> rad = new LinkedList<>();
    Queue<Integer> dir = new LinkedList<>();
    int i = 0;

    for (char ch : senate.toCharArray()) {
      if (ch == 'R') {
        rad.offer(i++);
      } else {
        dir.offer(i++);
      }
    }

    while (!rad.isEmpty() && !dir.isEmpty()) {
      if (rad.poll() < dir.poll()) {
        rad.offer(i++);
      } else {
        dir.offer(i++);
      }
    }

    return !rad.isEmpty() ? "Radiant" : "Dire";
  }
}
