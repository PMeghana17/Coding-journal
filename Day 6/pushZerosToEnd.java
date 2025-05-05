class Solution {
    void pushZerosToEnd(int[] arr) {
        // code here
        //how about using 2 pointers
        int i=0;//pointing at start
        
        //1 2 0 4 3 0 5 0
        //1 2 4 0 3 0 5 0
        //1 2 
        for(int k=0;k<arr.length;k++)
        {
            if(arr[k]!=0)
            {
                int temp=arr[i];
                arr[i]=arr[k];
                arr[k]=temp;
               // System.out.println(i);
                i++;
            }
            
        }

      
      
    }
}


Mistakes
-First time when i submitted the code not even single test case passed because at line 12 i wrote the code as if(arr[i]!=0) 
  which is a blunder mistake....if i compre with arr[i] it won't always check every value .so we should place arr[k] there.
