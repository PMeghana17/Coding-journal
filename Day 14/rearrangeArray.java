class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] posarr=new int[nums.length/2];//different array for positive values
        int[] negarr=new int[nums.length/2];//different array for negative values
        int idx=0;
        int idx2=0;

        for(int i:nums)
        {
            if(i>0) posarr[idx++]=i;
            else{
                negarr[idx2++]=i;
            }
        }

         idx=0;
         idx2=0;

      //if i is even then assign value of posarr to that index
      //if i is odd assign value of negarr to that index
        for(int i=0;i<nums.length;i++)
        {
            if(i%2==0) nums[i]=posarr[idx++];
            else nums[i]=negarr[idx2++];
        }

        return nums;
    }
}

TC:O(N)+O(N/2)==>O(N)
SC:O(N/2)+O(N/2)=O(N)
