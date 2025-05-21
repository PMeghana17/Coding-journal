class Solution {

    // a: input array
    // n: size of array
    // Function to find maximum circular subarray sum.
    public int circularSubarraySum(int arr[]) {

        // Your code here
       int maxsum=arr[0];
       int minsum=arr[0];
       int currMaxsum=0;
       int totalsum=0;
       int currMinsum=0;
       
       for(int i=0;i<arr.length;i++)
       {
           currMaxsum=Math.max(arr[i],currMaxsum+arr[i]);
           maxsum=Math.max(maxsum,currMaxsum);
           
           currMinsum=Math.min(arr[i],currMinsum+arr[i]);
           minsum=Math.min(minsum,currMinsum);
           
           totalsum+=arr[i];
           
       }
        
        int nrmlsum=maxsum;
        int circularsum=totalsum-minsum;
        
        if(minsum==totalsum) return nrmlsum;
        
        return Math.max(nrmlsum,circularsum);
        
         
    }
}


TC:O(n)
SC:O(1)
