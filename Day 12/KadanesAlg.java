class Solution {
    public int maxSubArray(int[] nums) {
        int curr=0;
        int maxsum=Integer.MIN_VALUE;
        //suppose the minimum sum should be '0' (if this is one of constraint)
        //then we can initialize with maxsum=0
        for(int i=0;i<nums.length;i++)
        {
            curr=nums[i]+curr;
            maxsum=Math.max(curr,maxsum);

            // the main part of this kadane's alg is this if my sum
            //is dercresing i.e. it going to negative values then there
            //is no use of keep calculating that subarray sum 
            //if we find our sum is going in negatives then we can stop right there
            if(curr<0) curr=0;
        }
        return maxsum;
    }
}

TC:O(N)
SC:O(1)
