class Solution {
    public int countSubarrays(int[] nums) {
        int count = 0;
        for (int i = 0; i <= nums.length - 3; i++) {
            int first = nums[i];
            int middle = nums[i + 1];
            int third = nums[i + 2];
            
            if ((first + third) * 2 == middle) {
                count++;
            }
        }
        return count;
    }
}