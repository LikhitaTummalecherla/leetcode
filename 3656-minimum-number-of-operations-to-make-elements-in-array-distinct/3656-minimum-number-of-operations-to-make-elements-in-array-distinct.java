

class Solution {
    public int minimumOperations(int[] nums) {
        int operations = 0;

        while (true) {
           
            Set<Integer> set = new HashSet<>();
            boolean isDistinct = true;
            for (int num : nums) {
                if (!set.add(num)) {
                    isDistinct = false;
                    break;
                }
            }

            if (isDistinct) break;

            
            operations++;
            nums = Arrays.copyOfRange(nums, Math.min(3, nums.length), nums.length);
        }

        return operations;
    }
}