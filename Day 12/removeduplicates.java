class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0;

        //better approach
        //we can also try using Hashset
        for(int j=1;j<nums.length;j++)
        {
            // This is using Two pointers---i and j
            if(nums[i]!=nums[j]) //we check till the i and j are differnt
                                //then replace the different value
                                //the sliding window contains only repeated values.
            {
                i++;
                nums[i]=nums[j];
            }
        }

        System.out.println(Arrays.toString(nums));

        return i+1;

    }
}

//TC:O(N)
//SC:O(1)
