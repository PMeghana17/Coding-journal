class Solution {
    int countFreq(int[] arr, int target) {
        // code here
        int freq=lastIndex(target,arr)-firstIndex(target,arr)+1;
        
        return freq;
    }
    
    int lastIndex(int target,int[] arr)
    {
        int low=0;
        int high=arr.length-1;
        
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            
            if(arr[mid]<=target)
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return high;
    }
    
    int firstIndex(int target,int[] arr)
    {
        int low=0;
        int high=arr.length-1;
        
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            
            if(arr[mid]>=target)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return low;
    }
}
