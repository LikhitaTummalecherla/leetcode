class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        int maxFruits = 0;
        int left = 0, right = 0;
        int total = 0;

        while (right < n) {
            total += fruits[right][1];

            while (left <= right && !canReach(fruits[left][0], fruits[right][0], startPos, k)) {
                total -= fruits[left][1];
                left++;
            }

            maxFruits = Math.max(maxFruits, total);
            right++;
        }

        return maxFruits;
    }

    private boolean canReach(int posL, int posR, int start, int k) {
        int goLeftFirst = Math.abs(start - posL) + (posR - posL);
        int goRightFirst = Math.abs(start - posR) + (posR - posL);
        return Math.min(goLeftFirst, goRightFirst) <= k;
    }
}