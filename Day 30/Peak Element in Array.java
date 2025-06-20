Peak Element in Array
Given an array arr[] where no two adjacent elements are same, find the index of a peak element.
  An element is considered to be a peak element if it is strictly greater than its adjacent elements. 
  If there are multiple peak elements, return the index of any one of them.

Note: Consider the element before the first element and the element after the last element to be negative infinity.

Examples:

Input: arr[] = [1, 2, 4, 5, 7, 8, 3]
Output: 5
Explanation: arr[5] = 8 is a peak element because arr[4] < arr[5] > arr[6].

Input: arr[] = [10, 20, 15, 2, 23, 90, 80]
Output: 1 or 5
Explanation: arr[1] = 20 and arr[5] = 90 are peak elements because arr[0] < arr[1] > arr[2] and arr[4] < arr[5] > arr[6].

Input: arr[] = [1, 2, 3]
Output: 2
Explanation: arr[2] is a peak element because arr[1] < arr[2] and arr[2] is the last element, so it has negative infinity to its right.

Table of Content

[Naive Approach] Using Linear Search - O(n) Time and O(1) Space
[Expected Approach] Using Binary Search - O(logn) Time and O(1) Space
[Naive Approach] Using Linear Search - O(n) Time and O(1) Space
The simplest approach is to iterate through the array and check if an element is greater than its neighbors. 
  If it is, then it's a peak element.




// Java program to find a peak element in the given array
// Using Linear Search
​
import java.util.*;
class GfG {
    static int peakElement(int[] arr) {
        int n = arr.length;
​
        for (int i = 0; i < n; i++) {
            boolean left = true;
            boolean right = true;
​
            // Check for element to the left
            if (i > 0 && arr[i] <= arr[i - 1])
                left = false;
​
            // Check for element to the right
            if (i < n - 1 && arr[i] <= arr[i + 1])
                right = false;
​
            // If arr[i] is greater than its left as well as
            // its right element, return its index
            if (left && right) {
                return i;
            }
        }
        return 0;
    }
​
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 7, 8, 3};
        System.out.println(peakElement(arr));
    }
}


Output
5
[Expected Approach] Using Binary Search - O(logn) Time and O(1) Space
If we observe carefully, we can say that:

If an element is smaller than it's next element then it is guaranteed that at least one peak element will exist on the
  right side of this element.
Conversely if an element is smaller than it's previous element then it is guaranteed that at least one peak element will exist 
  on the left side of this element.
Therefore, we can use binary search to find the peak element.

Why it is guaranteed that peak element will definitely exist on the right side of an element, if its next element is greater than it?

If we keep moving in the right side of this element, as long as the elements are increasing, we will eventually
  reach an element that is either:

The last element of the array, which will be a peak as it is greater than or equal to its previous element.
An element where the sequence is no longer increasing, i.e., arr[i] > arr[i + 1], which would be a peak element.
For the same reasons, if an element is lesser than its previous element, then it is guaranteed that at least one peak 
  element will exist on the left side of that element.

Find-peak-element-using-Binary-Search-5.webpFind-peak-element-using-Binary-Search-5.webp





// Java program to find a peak element in the given array
// Using Binary Search
​
class GfG {
​
    static int peakElement(int[] arr) {
        int n = arr.length;
​
        // If there is only one element, then it's a peak
        if (n == 1)
            return 0;
​
        // Check if the first element is a peak
        if (arr[0] > arr[1])
            return 0;
​
        // Check if the last element is a peak
        if (arr[n - 1] > arr[n - 2])
            return n - 1;
​
        // Search Space for binary Search
        int lo = 1, hi = n - 2;
​
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
​
            // If the element at mid is a  
            // peak element return mid
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])
                return mid;
​
            // If next neighbor is greater, then peak
            // element will exist in the right subarray
            if (arr[mid] < arr[mid + 1])
                lo = mid + 1;
​
            // Otherwise, it will exist in left subarray
            else
                hi = mid - 1;
        }
​
        return 0;
    }
​
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 7, 8, 3};
        System.out.println(peakElement(arr));
    }
}

Output
5
Related Articles:

Find local minima in an array
