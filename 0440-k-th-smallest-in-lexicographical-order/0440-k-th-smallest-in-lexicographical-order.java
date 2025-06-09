class Solution {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k--; // since we start at 1, we already have our first number
        
        while (k > 0) {
            long steps = countSteps(n, curr, curr + 1);
            if (steps <= k) {
                curr++; // go to next sibling
                k -= steps;
            } else {
                curr *= 10; // go to first child
                k--;
            }
        }
        
        return curr;
    }

    // Counts the number of nodes between prefix1 and prefix2 in lexicographical order up to n
    private long countSteps(int n, long prefix1, long prefix2) {
        long steps = 0;
        while (prefix1 <= n) {
            steps += Math.min(n + 1, prefix2) - prefix1;
            prefix1 *= 10;
            prefix2 *= 10;
        }
        return steps;
    }
}