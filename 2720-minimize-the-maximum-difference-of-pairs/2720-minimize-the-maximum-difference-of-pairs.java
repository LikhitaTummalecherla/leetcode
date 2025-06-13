import java.util.Arrays;

class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums); // Step 1: Sort the array
        
        int left = 0, right = nums[nums.length - 1] - nums[0];
        int answer = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canFormPairs(nums, p, mid)) {
                answer = mid;
                right = mid - 1; // Try smaller difference
            } else {
                left = mid + 1; // Increase difference
            }
        }

        return answer;
    }

    // Helper: check if we can form at least p pairs with max diff <= maxDiff
    private boolean canFormPairs(int[] nums, int p, int maxDiff) {
        int count = 0;
        int i = 0;
        while (i < nums.length - 1) {
            if (nums[i + 1] - nums[i] <= maxDiff) {
                count++;
                i += 2; // skip next to avoid overlapping
            } else {
                i++;
            }
        }
        return count >= p;
    }
}