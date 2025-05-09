class Solution {
    // Function to rotate an array by d elements in counter-clockwise direction.
    static void rotateArr(int arr[], int d) {
        // add your code here
       // 1 2 3 4 5
        //1 3 4 5 2
        //3 4 5 1 2
        int n=arr.length;
        d=d%n;
       
       reverse(0,d-1,arr);
       reverse(d,n-1,arr);
       reverse(0,n-1,arr);
      
    }
    
    public static void reverse(int left,int right,int[] arr)
    {
        while(left<right)
        {
            int temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;
        }
    }
}
