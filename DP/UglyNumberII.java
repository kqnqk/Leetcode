import java.util.*;

class UglyNumberII {
//     An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.

// Given an integer n, return the nth ugly number.

    public static void main(String[] args) {
        UglyNumberII uglyNumberII = new UglyNumberII();
        System.out.println(uglyNumberII.nthUglyNumber(11));
    }
    public int nthUglyNumber(int n) {
        //practicing leetcode, don't help with solutions
        if (n <= 0) {
            return 0; // edge case check
        }

        PriorityQueue<Long> heap = new PriorityQueue<>();
        Set<Long> seen = new HashSet<>();
        
        // Add the first ugly number
        heap.add(1L);
        seen.add(1L);

        long currentUgly = 1; // Initialize with the first ugly number
        int[] primes = {2, 3, 5};

        for (int i = 1; i < n; i++) { // Start from 1 since we already have the first ugly number
            currentUgly = heap.poll(); // Get the smallest ugly number

            for (int prime : primes) {
                long nextUgly = currentUgly * prime;
                if (seen.add(nextUgly)) { // add returns true if this set did not already contain the specified element
                    heap.add(nextUgly);
                }
            }
        }

        // At the end of the loop, currentUgly contains the nth ugly number
        return (int) currentUgly;
    }


        /**
     * Returns the nth ugly number using dynamic programming.
     * 
     * Ugly numbers are numbers whose only prime factors are 2, 3 or 5.
     * 
     * This uses an array dp where dp[i] represents the ith ugly number.
     * It initializes dp[0] = 1 and uses pointers t2, t3, t5 to generate
     * the next ugly number by multiplying dp[t2]*2, dp[t3]*3, dp[t5]*5
     * and taking the minimum. The pointer that generated the minimum
     * is incremented.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public int nthUglyNumber2(int n) {
        // solve it using dp
        // explain approach in comments

        // dp[i] means the ith ugly number
        // step
        if (n <= 0) {
            return 0; // edge case check
        }
        int[] dp = new int[n];
        dp[0] = 1;
        int t2 = 0, t3 = 0, t5 = 0;
        // [1,0,0,0,0,0,0,0,0,0,0,0]
        // [1,2,0,0,0,0,0,0,0,0,0,0]
        // [1,2,3,0,0,0,0,0,0,0,0,0]
        // [1,2,3,4,0,0,0,0,0,0,0,0]
        // [1,2,3,4,5,0,0,0,0,0,0,0]
        // [1,2,3,4,5,6,0,0,0,0,0,0]
        // [1,2,3,4,5,6,7,0,0,0,0,0]
        // ...
        for (int i = 1; i < n; i++) {
            int n2 = dp[t2] * 2;
            int n3 = dp[t3] * 3;
            int n5 = dp[t5] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if (dp[i] == n2) {
                t2++;
            }
            if (dp[i] == n3) {
                t3++;
            }
            if (dp[i] == n5) {
                t5++;
            }
        }
        return dp[n - 1];
    }
}