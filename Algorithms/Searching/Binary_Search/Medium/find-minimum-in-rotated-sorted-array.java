
// Array, Binary Search

// create and assign variables left and right as 0 and nums.length - 1,
// run a loop till left < right, calculate the mid, then check if nums[mid] < nums[right], this means nums[mid] is smaller, so no need to check the right side as it is a rotated sorted array, check left side by making right = mid,
// else that means the nums[mid] is greater than nums[right], the smaller element lies on the left side of the mid, left = mid + 1,
// finally return the nums[mid];

package Algorithms.Searching.Binary_Search.Medium;

class Solution {
  public int findMin(int[] nums) {
    int left = 0, right = nums.length - 1;

    while (left < right) {
      int mid = left + ((right - left) / 2);

      if (nums[mid] < nums[right]) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }

    return nums[left];
  }
}
