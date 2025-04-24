

class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        Set<Integer> uniqueElements = new HashSet<>();
        
        for (int num : nums) {
            uniqueElements.add(num);
        }
        int totalDistinct = uniqueElements.size();

        int count = 0;

        for (int i = 0; i < n; i++) {
            Set<Integer> currentSet = new HashSet<>();
            for (int j = i; j < n; j++) {
                currentSet.add(nums[j]);
                if (currentSet.size() == totalDistinct) {
                    count++;
                }
            }
        }

        return count;
    }
}