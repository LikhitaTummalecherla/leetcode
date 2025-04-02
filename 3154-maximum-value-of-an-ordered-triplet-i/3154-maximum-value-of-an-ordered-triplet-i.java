class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long maxVal = 0;

        int maxPrefix = nums[0];
        int[] maxSuffix = new int[n];

        maxSuffix[n-1] = nums[n-1];
        for (int k=n-2;k>=0;k--){
            maxSuffix[k]=Math.max(maxSuffix[k+1],nums[k]);
        }
        for (int j=1;j<n-1;j++){
            maxVal = Math.max(maxVal, (long)(maxPrefix - nums[j]) * maxSuffix[j+1]);
            maxPrefix = Math.max(maxPrefix, nums[j]);
        }
        return maxVal;
    }
}