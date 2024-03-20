package SlidingWindows;
import java.util.Arrays;

public class LSubreaptingK {
    // 395. Longest Substring with At Least K Repeating Characters

    //siliding windows
//     Approach 3: Sliding Window
// Intuition

// There is another intuitive method to solve the problem by using the Sliding Window Approach. The sliding window slides over the string s and validates each character. Based on certain conditions, the sliding window either expands or shrinks.

// A substring is valid if each character has at least k frequency. The main idea is to find all the valid substrings with a different number of unique characters and track the maximum length. Let's look at the algorithm in detail.

// Algorithm

// Find the number of unique characters in the string s and store the count in variable maxUnique. For s = aabcbacad, the unique characters are a,b,c,d and maxUnique = 4.

// Iterate over the string s with the value of currUnique ranging from 1 to maxUnique. In each iteration, currUnique is the maximum number of unique characters that must be present in the sliding window.

// The sliding window starts at index windowStart and ends at index windowEnd and slides over string s until windowEnd reaches the end of string s. At any given point, we shrink or expand the window to ensure that the number of unique characters is not greater than currUnique.

// If the number of unique character in the sliding window is less than or equal to currUnique, expand the window from the right by adding a character to the end of the window given by windowEnd

// Otherwise, shrink the window from the left by removing a character from the start of the window given by windowStart.

// Keep track of the number of unique characters in the current sliding window having at least k frequency given by countAtLeastK. Update the result if all the characters in the window have at least k frequency.

    public static void main(String[] args) {
        // System.out.println(longestSubstring("ababbc", 2));
        System.out.println(longestSubstringUtil("ababbc", 0, "ababbc".length(), 2));
    }


        /**
     * Finds the length of the longest substring in string s that contains at least
     * k occurrences of each character.
     * 
     * Iterates over s with currUnique ranging from 1 to max number of unique chars.
     * currUnique is the max number of unique chars in the sliding window.
     * 
     * The window slides over s, shrinking and expanding to keep number of unique
     * chars <= currUnique.
     * 
     * Tracks number of unique chars with frequency >= k in window (countAtLeastK).
     * 
     * Updates result if all chars in window have frequency >= k.
     */
    public static int longestSubstring(String s, int k) {
        char[] str = s.toCharArray();
        int[] countMap = new int[26];
        int maxUnique = getMaxuniques(s);
        int res = 0;
        // The key reason we need this loop is because we don't know ahead of time the optimal 
        // number of unique chars K for the longest valid substring. So we try all possibilities by iterating currUnique from 1 to maxUnique.
        for (int currUnique = 1; currUnique <= maxUnique; currUnique++) {
            // reset countMap
            Arrays.fill(countMap, 0);
            int windowStart = 0, windowEnd = 0, idx = 0, unique = 0, countAtLeastK = 0;
            while (windowEnd < str.length) {
                if (unique <= currUnique) {
                    idx = str[windowEnd] - 'a';
                    if (countMap[idx] == 0)
                        unique++;
                    countMap[idx]++;
                    if (countMap[idx] == k)
                        countAtLeastK++;
                    windowEnd++;
                }
                // shrink the sliding window
                else {
                    idx = str[windowStart] - 'a';
                    if (countMap[idx] == k)
                        countAtLeastK--;
                    countMap[idx]--;
                    if (countMap[idx] == 0)
                        unique--;
                    windowStart++;
                }
                if (unique == currUnique && unique == countAtLeastK)
                    res = Math.max(windowEnd - windowStart, res);
            }
        }
        return res;
        


    } // Time Complexity: O(N*K) where N is length of string and K is minimum frequency

    public static int longestSubstringUtil(String s, int start, int end, int k) {
        // base case
        if(end < k) return 0;

        int [] memo = new int[26];
        for(char c: s.toCharArray()) memo[c-'a']++;
        for(int i = start; i< end; i++){
            if(memo[s.charAt(i)-'a'] >= k) continue;
            int midNext = i+1;
            while( midNext < end && memo[s.charAt(midNext)-'a'] < k) midNext++;
            return Math.max(longestSubstringUtil(s,start,i, k), longestSubstringUtil(s,midNext,end, k));
            
        }

        return end - start;
    }

    private static int getMaxuniques(String s) {
        boolean map[] = new boolean[26];
        int maxUnique = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!map[s.charAt(i) - 'a']) {
                maxUnique++;
                map[s.charAt(i) - 'a'] = true;
            }
        }
        return maxUnique;
    }

    public static boolean isValid(String s, int k, int[] countMap){
        int countLetters = 0, countAtLeastK = 0;
        for( int freq: countMap){
            if(freq > 0) countLetters++;
            if(freq >= k) countAtLeastK++;
        }
        return countAtLeastK == countLetters;
    }
}
