
class Solution {
    // Function to find the smallest positive number missing from the array.
    public int missingNumber(int[] arr) {
        // Your code here
        Arrays.sort(arr);
        int index1=-1;
        
        for(int i=0;i<arr.length;i++)
        {
            
            if(arr[i]==1)
            {
                 index1=i;
            }
        }
        
        if(index1==-1) return 1;
        
        int num=2;
        
        
        for(int i=index1+1;i<arr.length;i++)
        {
            if(arr[i]==num)
            {
                num+=1;
            }
            else if(arr[i]>num) {
                break;
            }
            
        }
     
        return num;
        
    }
}
