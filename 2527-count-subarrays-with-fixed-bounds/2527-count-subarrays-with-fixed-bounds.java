class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        long count = 0;

        int leftBound = -1;  
        int lastMin = -1;    
        int lastMax = -1;    

        for (int i = 0; i < n; i++) {
            int num = nums[i];

            
            if (num < minK || num > maxK) {
                leftBound = i;
            }

            if (num == minK) lastMin = i;
            if (num == maxK) lastMax = i;

            int validStart = Math.min(lastMin, lastMax);
            if (validStart > leftBound) {
                count += validStart - leftBound;
            }
        }

        return count;
    }
}
