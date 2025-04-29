import java.util.*;
public class tuf {
 
  public static void main(String args[]) {
 
    int arr1[] =  {2,5,1,3,0};
    System.out.println("The Largest element in the array is: " + sort(arr1));
   
    int arr2[] =  {8,10,5,7,9};
    System.out.println("The Largest element in the array is: " + sort(arr2));
  }
  static int sort(int arr[]) {
    Arrays.sort(arr);
    return arr[arr.length - 1];
  }
}

--------------------------------------------------
Method 2 
 {
 public static void main(String args[]) {
  int max=Integer.MIN_VALUE;
  for(int i=0;i<nums.length;i++)
   {
    max=Math.max(max,nums[i]);
    }
 }
}
Output:

The Largest element in the array is: 5
The Largest element in the array is: 10
