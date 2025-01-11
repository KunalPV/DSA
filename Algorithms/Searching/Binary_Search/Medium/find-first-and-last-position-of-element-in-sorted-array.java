
// Array, Binary Search

// create an array result of length 2, and call findFirst(nums, target) and store on 0th index and call findLast(nums, target) and store on 1st index.
// in findFirst(int nums[], int target), set the left and right to 0 and nums.length - 1, and assign -1 to idx variable, run a loop till left <= right, calcluate the mid, then check if nums[mid] >= target, if yes then right = mid - 1, else left = mid + 1, and check if nums[mid] equals target, if yes then set the idx as mid and return idx at the end.
// in findLast(int nums[], int target), set the left and right to 0 and nums.length - 1, and assign -1 to idx variable, run a loop till left <= right, calculate the mid, then check of nums[mid] <= target, if yes then left  = mid + 1, else right = mid - 1, and check if nums[mid] equals target, if yes then set the idx as mid and return idx at the end.

// ** difference between the firstFirst() and findLast() is that findFirst() checks the elem and compares to target from the left side of the nums array and findLast() checks the elem and compares to the target from the right side of the nums array.

package Algorithms.Searching.Binary_Search.Medium;

class Solution {
  private int left;
  private int right;

  public int[] searchRange(int[] nums, int target) {
    int result[] = new int[2];

    result[0] = findFirst(nums, target);
    result[1] = findLast(nums, target);

    return result;
  }

  private int findFirst(int nums[], int target) {
    left = 0;
    right = nums.length - 1;
    int idx = -1;

    while (left <= right) {
      int mid = left + ((right - left) / 2);

      if (nums[mid] >= target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }

      if (nums[mid] == target) {
        idx = mid;
      }
    }

    return idx;
  }

  private int findLast(int nums[], int target) {
    left = 0;
    right = nums.length - 1;
    int idx = -1;

    while (left <= right) {
      int mid = left + ((right - left) / 2);

      if (nums[mid] <= target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }

      if (nums[mid] == target) {
        idx = mid;
      }
    }

    return idx;
  }
}
