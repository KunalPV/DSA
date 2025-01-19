
// Array

// Solution1:
// use nested loop to product the elems with all other elems,
// continue when i == j (this avoids multiplying the elem by itself)
// assign the res[i] = product after all j iterations
// return res;

// Solution2: (Optimal) 0 may come once or never comes
// create var zeros, idx, prod
// loop till n, if nums[i] == 0, then increment zeros by 1, and save the index (idx = i), else prod = prod * arr[i]
// check if zeros == 0, if yes then loop till n, res[i] = prod / arr[i];
// check if zeros == 1, if yes then res[idx] = prod, all other elements will by 0
// return res;

package Data_Structures.Array.Easy;

import java.util.*;

// Brute Force
// Time: O(n ^ 2), n * n, n = nums.length
// Space: O(1), we define the array once at the start, so constant time.
class Solution1 {
  public int[] productExceptSelf(int nums[]) {
    int n = nums.length;
    int res[] = new int[n];

    for (int i = 0; i < n; i++) {
      int product = 1;
      for (int j = 0; j < n; j++) {
        if (i == j) {
          continue;
        }

        product = product * nums[j];
      }

      res[i] = product;
    }

    return res;
  }
}

// Optimal Solution: 0 can exist once or never in the array
// Time: O(n), n + n, n = nums.length
// Space: O(1), res array created only once
class Solution2 {
  public int[] productExceptSelf(int nums[]) {
    int zeros = 0, prod = 1, idx = 0;
    int n = nums.length;
    int res[] = new int[n];
    Arrays.fill(res, 0);

    for (int i = 0; i < n; i++) {
      if (nums[i] == 0) {
        zeros++;
        idx = i;
      } else {
        prod *= nums[i];
      }
    }

    if (zeros == 0) {
      for (int i = 0; i < n; i++) {
        res[i] = prod / nums[i];
      }
    }
    if (zeros == 1) {
      res[idx] = prod;
    }

    return res;
  }
}