public class Solution {
    public long distributeCandies(int n, int limit) {
        long result = 0;
        for (int mask = 0; mask < 8; mask++) {
            int bits = Integer.bitCount(mask);
            long sum = n;
            for (int i = 0; i < 3; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum -= (limit + 1);
                }
            }
            if (sum < 0) continue;
            long ways = comb(sum + 2, 2);
            if (bits % 2 == 0) {
                result += ways;
            } else {
                result -= ways;
            }
        }
        return result;
    }

    // Computes C(n, 2) safely using long
    private long comb(long n, long k) {
        if (k < 0 || k > n) return 0;
        // Only k = 2 is used here, so we directly use optimized formula
        return n * (n - 1) / 2;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.distributeCandies(5, 2)); // 3
        System.out.println(sol.distributeCandies(3, 3)); // 10
        System.out.println(sol.distributeCandies(257169, 765944)); // 33068333035
    }
}