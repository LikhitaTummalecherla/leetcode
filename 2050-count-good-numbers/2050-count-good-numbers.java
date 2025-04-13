class Solution {
    public int countGoodNumbers(long n) {
        final int MOD = 1_000_000_007;
        long evenCount = (n + 1) / 2; 
        long oddCount = n / 2;        


        long evenWays = power(5, evenCount, MOD);
        long oddWays = power(4, oddCount, MOD);

        return (int)((evenWays * oddWays) % MOD);
    }

    private long power(long base, long exp, int mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) { // If exp is odd
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }
}