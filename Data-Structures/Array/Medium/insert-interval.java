import java.util.*;

// Arrays, Interval

// create a list and update newInterval accordingly
// case 1: {2, 5} [1] < {3, 6} [0] => add newInterval to list and update newInterval as interval
//case 2: {2, 5} [0] > {0, 1} [1] => add interval to list
//case 3: last case where newInterval overlaps with interval, update newInterval [0] with min of interval[0] and newInterval[0] And [1] with max of interval[1] and newInterval[1]
// add newInterval at last and return

class Solution {
  public int[][] insert(int[][] intervals, int[] newInterval) {
    List<int[]> list = new ArrayList<>();

    for (int[] interval : intervals) {
      if (newInterval[1] < interval[0]) {
        list.add(newInterval);
        newInterval = interval;
      } else if (interval[1] < newInterval[0]) {
        list.add(interval);
      } else {
        newInterval[0] = Math.min(interval[0], newInterval[0]);
        newInterval[1] = Math.max(interval[1], newInterval[1]);
      }
    }

    list.add(newInterval);

    return list.toArray(new int[list.size()][]);
  }
}
