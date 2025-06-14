class Solution {
    public int minMaxDifference(int num) {
        String s = String.valueOf(num);

        // Step 1: Maximize the number by changing a digit to 9
        char toMax = ' ';
        for (char c : s.toCharArray()) {
            if (c != '9') {
                toMax = c;
                break;
            }
        }
        String maxStr = (toMax == ' ') ? s : s.replace(toMax, '9');

        // Step 2: Minimize the number by changing a digit to 0
        char toMin = ' ';
        for (char c : s.toCharArray()) {
            if (c != '0') {
                toMin = c;
                break;
            }
        }
        String minStr = (toMin == ' ') ? s : s.replace(toMin, '0');

        // Convert to integers and return the difference
        int maxVal = Integer.parseInt(maxStr);
        int minVal = Integer.parseInt(minStr);
        return maxVal - minVal;
    }
}