class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        
        while (left < right) {
            int mid = (left + right) / 2;
            
            if (mid % 2 == 1) {
                mid--; // make sure mid is even
            }
            
            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2; // go right
            } else {
                right = mid; // go left
            }
        }
        
        return nums[left];
    }
}
