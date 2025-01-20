
// Array, Two-Pointers

// Solution1:
// create maxVol var as 0,
// loop i till n, and nested loop j till n, calc breadth (j - i) and length (min of nums[i] and nums[j])
// update maxVol to max of maxVol and (length * breadth)
// return maxVol;

// Solution2:
// create 2 pointers left as 0 and right as nums.length - 1, and result as 0
// loop till left < right, create and calc water = product of (min of nums[left] and nums[right]) and (right - left)
// update result to (max of result and water)
// check if nums[left] < nums[right], if yes then move left by 1 index (left++),
// else move right by -1 index (right--),
// return result;

// Brute Force
// Time: O(n^2), nested loop (n * n), n = nums.length
// Space: O(1), maxVol, constant time
class Solution1 {
  public int maxWater(int nums[]) {
    int n = nums.length;
    int maxVol = 0;

    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        int breadth = j - i;
        int length = Math.min(nums[i], nums[j]);

        maxVol = Math.max(maxVol, length * breadth);
      }
    }

    return maxVol;
  }
}

// Optimal Solution
// Time: O(n), n = nums.length
// Space: O(1), result, constant space
class Solution2 {
  public int maxWater(int nums[]) {
    int left = 0, right = nums.length - 1;
    int result = 0;

    while (left < right) {
      int water = Math.min(nums[left], nums[right]) * (right - left);

      result = Math.max(result, water);

      if (nums[left] < nums[right]) {
        left++;
      } else {
        right--;
      }
    }

    return result;
  }
}