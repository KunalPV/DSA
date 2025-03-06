
// Searching, Binary Search
//
// create first and last as 1 and n,
// loop till first <= last,
// create mid as first + (last - first) / 2 and res as guess(n),
// check if(res == 0), if yes return n;
// else if(res == -1), last = mid - 1,
// else, first = mid + 1,
// return -1;
//
// Expected Solution: Binary Search
// Time: O(logn), for each iteration the search range is halved, n = given int n
// Space: O(1), O(1 + 1 + 1 + 1) [first + last + mid + res], constant time
class Solution {

    // guess func is given by default
    private int pick;

    public int guess(int num) {
        if (num == pick) {
            return 0;
        }

        return (num < pick) ? 1 : -1;
    }

    public int guessNum(int n) {
        int first = 1, last = n;

        while (first <= last) {
            int mid = first + (last - first) / 2;
            int res = guess(n);

            if (res == 0) {
                return mid;
            } else if (res == -1) {
                last = mid - 1;
            } else {
                first = mid + 1;
            }
        }

        return -1;
    }
}
