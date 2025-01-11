
// Array, Binary Search

// assign left and right pointer as 0 and nums.length - 1,
// run a loop till left <= right, calculate the mid, and check if nums[mid] equals target, if yes then we found the elem, return the mid (index);
// check if nums[left] < nums[mid], that means left side of mid is sorted, then check if target exists in the left side by (nums[left] <= target && target < nums[mid]), if it exists then move the right pointer to mid - 1 , else means target exists on the right side of the mid, left = mid + 1,
// else, that check the right side, here do the same check, check if target exists on the right side by (nums[mid] < target <= nums[right]), if it exists then left becomes mid + 1, if not then that means target is on the left side, so right = mid - 1,
// return -1 at the end, that means we looped through the whole array but didnt find any target match.

package Algorithms.Searching.Binary_Search.Medium;

class Solution {
  public int search(int[] nums, int target) {
    int left = 0, right = nums.length - 1;

    while (left <= right) {
      int mid = left + ((right - left) / 2);

      if (nums[mid] == target) {
        return mid;
      }

      if (nums[left] <= nums[mid]) {
        if (nums[left] <= target && target < nums[mid]) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      } else {
        if (nums[mid] < target && target <= nums[right]) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
    }

    return -1;
  }
}
