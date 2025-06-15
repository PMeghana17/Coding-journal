75. Sort Colors
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

 

Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]
 

Constraints:

n == nums.length
1 <= n <= 300
nums[i] is either 0, 1, or 2.
 
class Solution {
    public void sortColors(int[] nums) {
        // tc : 0 1 0 1 2 2 1
        //check for zero 1st zeroes should be at strating
        // This is my Solution
        int n=nums.length;
        int left=0;
        int right=n-1;
        // Place 0s at the start
        swapping(0,left,right,nums);
        left=index(0,nums);// new left starts after last 0

        // Place 1s next
        swapping(1, left, right, nums);
        // No need to place 2s; they are naturally at the end
        
        
    }

    public void swapping(int x,int left,int right,int[] nums)
    {
        while(left<=right)
        {
          if(nums[left]==x)
          {
            left++;
          }
          else if (nums[right]!=x)
          {
            right--;
          }
          else
          {
            // swap nums[left] and nums[right]
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
          }
        }
    }

    public int index(int y,int[] nums)
    {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != y) {
                return i;
            }
        }
        return nums.length; // all elements were y
    }
}


Total Time Complexity: O(n) + O(n) + O(n) = O(n)
Space Complexity: O(1)






  

Follow up: Could you come up with a one-pass algorithm using only constant extra space?




class Solution {
    public void sortColors(int[] nums) 
    {
        int i = 0; 
        int n = nums.length;
        int start = 0, end = n-1;
        
        while (i<=end)
        {
            if (nums[i] == 0) // Move to left
            {
                swap(nums, i, start);
                start++;
                i++;
            }
            
            else if (nums[i] == 1) // Dont Move
                i++;
                        
            else if (nums[i] == 2) // Move to Right
            {
                swap(nums, i, end);
                end--;
            }
        }
    }  
    
    
public void swap(int[] nums, int a, int b)
{
        int temp = nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
}

}
  
Total Time Complexity: O(n)
 Total Space Complexity: O(1)


