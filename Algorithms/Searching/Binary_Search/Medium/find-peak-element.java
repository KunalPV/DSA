
// Array, Binary Search

// declare variables left and right as 0 and nums.length - 1,
// run a loop till left < right, calculate the mid (left + ((right - left) / 2)),
// check if nums[mid] < nums[mid + 1], that means peak element lies on the right of mid, so left will be mid + 1,
// else that means peak might be mid or on the left side, so make right as mid and not mid - 1. (because peak might be mid)
// return left (and not mid because in some cases mid might be 1 elem before the actual peak elem).

// binary search works here on non-sorted array because we have to output any peak elem we find in the array.

package Algorithms.Searching.Binary_Search.Medium;

class Solution {
  public int findPeakElement(int[] nums) {
    int left = 0, right = nums.length - 1;

    while (left < right) {
      int mid = (left + ((right - left) / 2));

      if (nums[mid] < nums[mid + 1]) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }

    return left;
  }
}
