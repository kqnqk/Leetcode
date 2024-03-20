package Stack;

import java.util.Arrays;
import java.util.Stack;

// Given an integer array nums, you need to find one continuous subarray such that if you only sort this subarray in non-decreasing order, then the whole array will be sorted in non-decreasing order.
// Return the shortest such subarray and output its length.
public class LongestuContiSubAray {

    public static void main(String[] args) {
        System.out.println(findUnsortedSubarray(new int[]{2, 6, 4, 8, 10,9,15}));
    }
    // [2,6,4,8,10,9,15]
    //    l
    //[2,6,4,8,10,9,15]
    //          r
    // Using Stack. O(n), don't sort
    public static int findUnsortedSubarray(int[] nums) {
        var stack = new Stack<Integer>();
        int l = 0, r = 0;
        for(int i=0;i<nums.length;i++){
            while(!stack.isEmpty() && nums[stack.peek()]>nums[i]){
                l = Math.min(l,stack.pop());
            }
            stack.push(i);
        }

        for(int i=nums.length-1;i>=0;i--){
            while(!stack.isEmpty() && nums[stack.peek()]<nums[i]){
                r = Math.max(r,stack.pop());
            }
            stack.push(i);
        }
        return r-l>0?r-l:0;
        
    
    }

    // Time complexity : O(nlogn)

}
