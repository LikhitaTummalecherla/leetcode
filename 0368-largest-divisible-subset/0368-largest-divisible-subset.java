class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        
        int[] dp = new int[n]; 
        int[] prev = new int[n]; 
        
        int maxIndex = 0; 
        int maxLen = 0;
        
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            prev[i] = -1;
            
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        prev[i] = j;
                    }
                }
            }
            
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                maxIndex = i;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        while (maxIndex != -1) {
            result.add(nums[maxIndex]);
            maxIndex = prev[maxIndex];
        }
        
        Collections.reverse(result);
        return result;
    }
}