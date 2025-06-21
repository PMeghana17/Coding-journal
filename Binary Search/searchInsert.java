Search Insert Position
Solved
Easy
Topics
premium lock icon
Companies
Given a sorted array of distinct integers and a target value, return the index if the target is found.
  If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

  class Solution {
    public int searchInsert(int[] nums, int target) {

        int start=0;
        int end=nums.length-1;
    

        while(start<=end){
           int mid=(start+end)/2;
            //System.out.println(nums[mid]);
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]>target){
                end=mid-1;

            }
            else {
                start=mid+1;
            }
            
        }

        return start;
        
    }
}


TC:O(log n)
SC:O(1)
