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

TC:O(N)
SC:O(1)

----------------------------------------

✅ Optimal Solution (Dutch National Flag Algorithm):
This is the standard one-pass O(n) in-place solution using three pointers:

java
Copy
Edit
class Solution {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else { // nums[mid] == 2
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
✅ Time and Space Complexity:
Time Complexity: O(n) – single pass
Space Complexity: O(1) – in-place sorting
  
