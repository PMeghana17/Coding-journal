// User function Template for Java
class Solution {

    public List<Integer> findSplit(int[] arr) {
        // Return an array of possible answer, driver code will judge and return true or
        // false based onta
        int n=arr.length;
        int totalsum=0;
        
        for(int a:arr)
        {
            totalsum+=a;
        }
        
        if(totalsum%3!=0) return new ArrayList<>(Arrays.asList(-1,-1));
        
        int partsum=totalsum/3;
        int currentsum=0;
        int i=-1,j=-1;
        
        for(int k=0;k<n;k++)
        {
            currentsum+=arr[k];
            
            if(currentsum==partsum && i==-1)
            {
                i=k;
            }
            if(currentsum==2*partsum && i!=-1 && j==-1)
            {
                j=k;
                break;
            }
        }
        
        if(i!=-1 && j!=-1 && j<n-1)
        {
            int thirdsum=0;
            for(int k=j+1;k<n;k++)
            {
                thirdsum+=arr[k];
            }
            
            if(thirdsum==partsum) 
            return new ArrayList<>(Arrays.asList(i,j));
        }
        
        return new ArrayList<>(Arrays.asList(-1,-1));
        
    }
}


Time: O(n)
Space: O(1)
