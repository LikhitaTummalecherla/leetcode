import java.util.*;
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int l1 = a.length() - 1;
        int l2 = b.length() - 1;
        int c=0;
        while(l1>=0||l2>=0||c!=0) {
            int s=c;
            if(l1>=0) {
                s+=a.charAt(l1)-'0';
                l1--;
            }
            if(l2>=0) {
                s+=b.charAt(l2)-'0';
                l2--;
            }
            result.append(s%2);
            c=s/2;
        }
        return result.reverse().toString();
    
    }
}