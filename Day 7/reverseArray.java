
class Solution {
    public void reverseArray(int arr[]) {
        // code here
        int n=arr.length;
        for(int i=0;i<n/2;i++)
        {
            int temp=arr[i];
            arr[i]=arr[n-i-1];
            arr[n-i-1]=temp;
        }
        
    }
}

Mistakes I have Done During this question
-At fisrt i wrote the code at for block as 
      for(int i=0;i<n/2;i++)
     {
       arr[i]=arr[n-i-1];
     }
- I forgot that if i assign like this the output will be 
  i/p:  1 2 3 4 5 6
  o/p : 6 5 4 4 5 6

  As in the code we are not swapping the values we are directly assigning ... there is a difference.
  
