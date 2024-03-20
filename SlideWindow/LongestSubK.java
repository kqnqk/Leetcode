package SlideWindow;

import java.util.HashMap; 
import java.util.HashSet;
// Given a string s and an integer k, return the length of the longest 
// substring
//  of s that contains at most k distinct characters.

 

// Example 1:

// Input: s = "eceba", k = 2
// Output: 3
// Explanation: The substring is "ece" with length 3.
// Example 2:

// Input: s = "aa", k = 1
// Output: 2
// Explanation: The substring is "aa" with length 2.
public class LongestSubK {
    public static void main(String[] args) {
        
    }

    public static int longestSubstring(String s, int k) {
        int l = 0, r = 0;
        var max = Integer.MIN_VALUE;
        var set =new HashMap<Character,Integer>();

        while(r<s.length()){
            char c=s.charAt(r);
            set.put(c,set.getOrDefault(c,0)+1);

            while(set.size()>k){
                char d=s.charAt(l);
                set.put(d,set.get(d)-1);
                if(set.get(d)==0)
                    set.remove(d);
                l++;
            }
            max=Math.max(max,r-l+1);
            r++;
            
        }

        return max;
    }
}
