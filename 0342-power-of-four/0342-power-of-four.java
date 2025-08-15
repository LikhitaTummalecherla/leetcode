class Solution {
    public boolean isPowerOfFour(int n) {
        // 1. Must be positive
        if (n <= 0) return false;
        
        // 2. Keep dividing by 4 until it’s no longer divisible
        while (n % 4 == 0) {
            n /= 4;
        }
        
        // 3. If we end up with 1, it was a power of 4
        return n == 1;
    }
}
