
//Method -1
//TC: O(N)
class Solution {
    public int findMin(int[] arr) {
        // complete the function here
        int min=Integer.MAX_VALUE;
         for(int i=0;i<arr.length-1;i++)
        {
            min=Math.min(arr[i],min);
        }
        
        return min;
    }
}

//Method -2
//TC: O(N)--worst Case
class Solution {
    public int findMin(int[] arr) {
      for(int i=0;i<arr.length-1;i++)
        {
            if(arr[i]>arr[i+1]) return arr[i+1];
        }
        
        return arr[0];
    }
}

//Method -3
//Tc:O(log N)
class Solution {
    public int findMin(int[] arr) {

      int pivot=findPivot(nums);

        return pivot==-1?nums[0]:nums[pivot+1];

    }

    int findPivot(int[] nums)
    {
        int start=0;
        int end=nums.length-1;

        while(start<=end)
        {
            int mid=start+(end-start)/2;

            if(mid<end && nums[mid]>nums[mid+1]) return mid;
            if(mid>start && nums[mid]<nums[mid-1]) return mid-1;
            if(nums[mid]>nums[start]) start=mid+1;
            else end=mid-1;
        }
        return -1;
        
    }

}

//Method -4
//Tc:O(log N)

// Java program to find minimum element in a 
// sorted and rotated array using binary search

import java.util.*;
class GfG {
    static int findMin(int[] arr) {
        int lo = 0, hi = arr.length - 1;

        while (lo < hi) {
          
            // The current subarray is already sorted, 
            // the minimum is at the low index
            if (arr[lo] < arr[hi])        
                return arr[lo];
               
            // We reach here when we have at least
            // two elements and the current subarray
            // is rotated
          
            int mid = (lo + hi) / 2;

            // The right half is not sorted. So 
            // the minimum element must be in the
            // right half.
            if (arr[mid] > arr[hi])
                lo = mid + 1;
          
            // The right half is sorted. Note that in 
            // this case, we do not change high to mid - 1
            // but keep it to mid. As the mid element
            // itself can be the smallest
            else
                hi = mid;
        }

        return arr[lo]; 
    }

    public static void main(String[] args) {
        int[] arr = {5, 6, 1, 2, 3, 4};
        System.out.println(findMin(arr));
    }
}


