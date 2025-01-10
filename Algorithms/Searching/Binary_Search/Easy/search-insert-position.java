
// Array, Binary Search

// create 2 pointers start as 0 and end as last elem of array, then run a loop till start < end, calculate the mid by (start + ((end - start) / 2);), 
// then use the if else where if nums[mid] == target then just return the mid (index),
// else if nums[mid] > target, then target if smaller then mid elem of array, end = mid,
// else that means target is greater then mid elem, start = mid + 1
// finally before returning, check if nums[start] < target, then return start + 1, else return start.

// ** last edge case while returning is because if the elem is greater than the last elem of array, then we assume it should be placed after the last index.
// nums = {1, 3, 5, 7}, target = 9 => returns index 4.

package Algorithms.Searching.Binary_Search.Easy;

class Solution {
  public int searchInsert(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int start = 0, end = nums.length - 1;

    while (start < end) {
      int mid = start + ((end - start) / 2);

      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] > target) {
        end = mid;
      } else {
        start = mid + 1;
      }
    }

    return nums[start] < target ? start + 1 : start;
  }
}
