import java.util.*;

// Array, Interval, Sorting

// sort the array by taking the 1st element from the array of arrays
// create a List<int[]> and add the intervals elem as newInterval
// loop through intervals, if interval[0] <= newInterval[1] then replace the newInterval[1] with max int from interval[1] and newInterval[1]
// if not equals then assign interval to newIntervals and add to the list
// convert list to array as new int[list.size()][] and return

class Solution {
  public int[][] merge(int[][] intervals) {
    int n = intervals.length;

    if (n <= 1)
      return intervals;

    Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

    List<int[]> list = new ArrayList<>();
    int[] newInterval = intervals[0];
    list.add(newInterval);

    for (int[] interval : intervals) {
      if (interval[0] <= newInterval[1]) {
        newInterval[1] = Math.max(interval[1], newInterval[1]);
      } else {
        newInterval = interval;
        list.add(newInterval);
      }
    }

    return list.toArray(new int[list.size()][]);
  }
}