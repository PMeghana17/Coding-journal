class Solution:
    def nextPermutation(self, arr):
        n = len(arr)
        
        # If array is in descending order, return ascending
        if sorted(arr, reverse=True) == arr:
            arr.sort()
            return

        # Step 1: Find the pivot
        for i in range(n-1, 0, -1):
            if arr[i] > arr[i-1]:
                pivot = i
                break

        # Step 2: Find the next greater element and swap
        for i in range(n-1, pivot-1, -1):
            if arr[i] > arr[pivot-1]:
                arr[i], arr[pivot-1] = arr[pivot-1], arr[i]
                break

        # Step 3: Sort the suffix
        arr[pivot:] = sorted(arr[pivot:])
