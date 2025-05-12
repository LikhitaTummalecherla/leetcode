import java.util.*;

class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] count = new int[10];
        for (int d : digits) {
            count[d]++;
        }

        List<Integer> result = new ArrayList<>();

        for (int num = 100; num <= 999; num++) {
            if (num % 2 != 0) continue; 

            int a = num / 100;
            int b = (num / 10) % 10;
            int c = num % 10;

            int[] tempCount = Arrays.copyOf(count, 10);
            tempCount[a]--;
            tempCount[b]--;
            tempCount[c]--;

            if (tempCount[a] >= 0 && tempCount[b] >= 0 && tempCount[c] >= 0) {
                result.add(num);
            }
        }

        
        int[] resArr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resArr[i] = result.get(i);
        }
        return resArr;
    }
}