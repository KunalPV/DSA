
// Array, Two-Pointers

// Solution1
// create 2 arrays left and right with size as n, and water as 0
// fill the left array with max elems from nums from the left,
// do the same with right array with max elems from nums, but from the right,
// loop 1 till n - 1, calc the minOf2 by min(nums[left], nums[right])
// check if minOf2 is greater than nums[i], if yes than water = minOf2 - nums[i]
// return water;

// Solution2
// create two pointers left as 0 and right as nums.length - 1, and lMax as nums[left] and rMax as nums[right],
// loop till left <= right, check if lMax <= rMax,
// if yes, then update water as water + max(0, lMax - nums[left]), update lMax to max(lMax, nums[left]), and increment left pointer by 1,
// else, update water as water + max(0, rMax - nums[right]), update rMax to max(rMax, nums[right]), and decrement right pointer by 1,
// return water;

package Data_Structures.Array.Hard;

// Better Approach
// Time: O(n), n + n + n -> 3n -> n, n = nums.length
// Space: O(n), n (left) + n (right) + 1 (water) = n, n = nums.length
class Solution1 {
  public int maxWater(int nums[]) {
    int n = nums.length;
    int water = 0;

    int left[] = new int[n];
    int right[] = new int[n];

    left[0] = nums[0];
    for (int i = 1; i < n; i++) {
      left[i] = Math.max(left[i - 1], nums[i]);
    }

    right[n - 1] = nums[n - 1];
    for (int i = n - 2; i >= 0; i--) {
      right[i] = Math.max(right[i + 1], nums[i]);
    }

    for (int i = 1; i < n - 1; i++) {
      int minOf2 = Math.min(left[i], right[i]);

      if (minOf2 > nums[i]) {
        water += minOf2 - nums[i];
      }
    }

    return water;
  }
}

// Optimal Approach
// Time: O(n), each elem in nums is processed once, n = nums.length
// Space: O(1), left + right + lMax + rMax + water -> 1, constant space
class Solution2 {
  public int maxWater(int nums[]) {
    int left = 0;
    int right = nums.length - 1;

    int lMax = nums[left];
    int rMax = nums[right];

    int water = 0;

    while (left <= right) {
      if (lMax <= rMax) {
        water += Math.max(0, lMax - nums[left]);

        lMax = Math.max(lMax, nums[left]);

        left += 1;
      } else {
        water += Math.max(0, rMax - nums[right]);

        rMax = Math.max(rMax, nums[right]);

        right -= 1;
      }
    }

    return water;
  }
}