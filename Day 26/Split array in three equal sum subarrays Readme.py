Split array into three equal sum segments
Given an integer array arr[], the task is to divide the array into three non-empty contiguous segments with equal sum. 
In other words, we need to return an index pair [i, j], such that sum(arr[0...i]) = sum(arr[i+1...j]) = sum(arr[j+1...n-1]).

Note: If it is impossible to divide the array into three non-empty contiguous segments, return [-1, -1].

Examples:

Input: arr[] = [1, 3, 4, 0, 4]
Output: [1, 2]
Explanation: 3 equal sum segments are: arr[0...1], arr[2...2] and arr[3...4] each having sum = 4.

Input: arr[] = [2, 3, 4]
Output: [-1, -1]
Explanation: No three segments exist which has equal sum.

Input: arr[] = [1, -1, 1, -1, 1, -1, 1, -1]
Output: [1, 3]
Explanation: 3 equal sum segments are: arr[0...1], arr[2...3] and arr[4...7] each having sum = 0.

Table of Content

[Naive Approach] By finding all possible partitions - O(n^3) Time and O(1) Space
[Expected Approach] Finding first two segments- O(n) Time and O(1) Space
[Naive Approach] By finding all possible partitions - O(n^3) Time and O(1) Space
The idea is to try all possible partitions using two variables, say i and j such that the first segment will be arr[0...i],
the second segment will be arr[i+1...j] and the third segment will be arr[j+1...n-1]. For any partition, if the sum of all three segments are equal,
then we can return [i, j] as a valid partition. Otherwise, return [-1, -1].

// Java program to find if the array can be divided into
// three segments by finding all possible partitions

class GfG {
    
    // function to find the sum of subarray arr[start...end]
    static int findSum(int[] arr, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) 
            sum += arr[i];
        return sum;
    }

    // function to return the index pair of equal sum segments
    static int[] findSplit(int[] arr) {
        int n = arr.length;

        // First partition
        for (int i = 0; i < n - 2; i++) {

            // Second Partition
            for (int j = i + 1; j < n - 1; j++) {

                // Find sum of all three segments
                int sum1 = findSum(arr, 0, i);
                int sum2 = findSum(arr, i + 1, j);
                int sum3 = findSum(arr, j + 1, n - 1);

                // If all three segments have equal sum,
                // then return true
                if (sum1 == sum2 && sum2 == sum3)
                    return new int[]{i, j};
            }
        }

        // No possible index pair found
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 0, 4};
        int[] res = findSplit(arr);

        System.out.println(res[0] + " " + res[1]);
    }
}


Output
1 2
[Expected Approach] Finding first two segments- O(n) Time and O(1) Space
To split the array into three equal segments, we first need to make sure that the total sum of the array is divisible by 3.
Then, as we iterate through the array, we calculate the running sum. If running sum becomes equal to one-third of the total,
we reset the running sum to zero and store the index as the first element of the index pair.
If we find another index for which the running sum becomes equal to one-third of the total and there are still elements left for a third segment, 
then store the index as the second element of the index pair and return the index pair.

We only need the first two segments with sum equal to one-third of the total because the remaining subarray will always be the third segment.

Working:

// Java program to find if the array can be divided into
// three segments by finding first two segments

import java.util.Arrays;

class GfG {

    static int[] findSplit(int[] arr) {
        int[] res = new int[2];
        int n = arr.length;
        int resIdx = 0;
        int total = 0;

        for (int i = 0; i < n; i++)
            total += arr[i];

        // If the total sum is not divisible by 3,
        // it's impossible to split the array
        if (total % 3 != 0) {
            res[0] = -1;
            res[1] = -1;
            return res;
        }

        // Keep track of the sum of current segment
        int currSum = 0;

        for (int i = 0; i < n; i++) {
            currSum += arr[i];

            // If the valid segment is found, store its index
            // and reset current sum to zero
            if (currSum == total / 3) {
                currSum = 0;
                res[resIdx++] = i;

                // If two valid segments are found and third non
                // empty segment is possible, return true
                if (resIdx == 2 && i < n - 1) {
                    return res;
                }
            }
        }

        res[0] = -1;
        res[1] = -1;
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 0, 4};
        int[] res = findSplit(arr);

        System.out.println(res[0] + " " + res[1]);
    }
}



Output
1 2


