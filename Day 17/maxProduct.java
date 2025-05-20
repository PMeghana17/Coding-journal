class Solution {
    // Function to find maximum product subarray
    int maxProduct(int[] arr) {
        
        int maxsofar=arr[0];
        int minsofar=arr[0];
        int res=arr[0];
        
        for(int i=1;i<arr.length;i++)
        {
            int curr=arr[i];
            
            if(curr<0)
            {
                int temp=maxsofar;
                maxsofar=minsofar;
                minsofar=temp;
                
            }
            
            maxsofar=Math.max(curr,maxsofar*curr);
            minsofar=Math.min(curr,minsofar*curr);
            
            res=Math.max(res,maxsofar);
        }
        
    
        return res;
        
    }
}

⏱️ Time Complexity: O(n)
🧠 Space Complexity: O(1) — constant extra space.
