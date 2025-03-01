
// Array, Sorting, Binary Search, Two-Pointers
//
// create a new int pairs[] of n size, and Arrays.sort(potions)
// loop i = 0 till n, create spell, left and right as spells[i], 0 and m - 1,
// loop till left <= right, create mid as left + (right - left) / 2,
// create product as spell * potions[mid],
// check if(product >= success), if yes right = mid - 1,
// else, left = mid + 1,
// set pairs[i] = m - left,
// return pairs;
//
import java.util.*;

// Expected Solution
// Time: O(m logm + n logm), O(m logm) [Arrays.sort func] * O(n logm) [iterate through spells -> n * and peform binary search in each iteration -> logm] -> O(m logm + n logm), n = spells.length and m = potions.length
// Space: O(n), pairs array will be as long as spells array, n = spells.length
class Solution {

    public int[] successfulPairs(int spells[], int potions[], int success) {
        int n = spells.length;
        int m = potions.length;

        int pairs[] = new int[n];

        Arrays.sort(potions);

        for (int i = 0; i < n; i++) {
            int spell = spells[i];
            int left = 0, right = m - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                long product = (long) spell * potions[mid];

                if (product >= success) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            pairs[i] = m - left;
        }

        return pairs;
    }
}
