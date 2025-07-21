class Solution {
    public String makeFancyString(String s) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            int len = result.length();
            // Check if last two characters are same as current character
            if (len >= 2 && result.charAt(len - 1) == s.charAt(i) && result.charAt(len - 2) == s.charAt(i)) {
                continue;  // skip adding the third consecutive character
            }
            result.append(s.charAt(i));
        }
        
        return result.toString();
    }
}