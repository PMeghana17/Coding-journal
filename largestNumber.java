179. Largest Number
Solved
Medium
Topics
premium lock icon
Companies
Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.

Since the result may be very large, so you need to return a string instead of an integer.

 

Example 1:

Input: nums = [10,2]
Output: "210"
Example 2:

Input: nums = [3,30,34,5,9]
Output: "9534330"
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 109





CODE:  
class Solution {
    public String largestNumber(int[] nums) {
        String[] str=new String[nums.length];
        int i=0;

        for(int num:nums)
        {
            str[i++]=String.valueOf(num);
        }

       Arrays.sort(str, (a, b) -> (b + a).compareTo(a + b));

        //System.out.println(Arrays.toString(str));

        String res="";

        for(String s:str)
        {
            res+=s;
        }


       return res.charAt(0)=='0'?"0":res;

    }
}  


Time Complexity: O(n log n * k)
Space Complexity: O(n * k)
