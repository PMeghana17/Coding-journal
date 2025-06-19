class Solution {
    int search(int[] arr, int key) {
        int n = arr.length;
        int pivot = findPivot(arr, n);

        // Case 1: Not rotated at all
        if (pivot == -1) {
            return binarySearch(arr, 0, n - 1, key);
        }

        // Case 2: Found pivot
        if (arr[pivot] == key) return pivot;

        if (key >= arr[0]) {
            return binarySearch(arr, 0, pivot - 1, key);
        } else {
            return binarySearch(arr, pivot + 1, n - 1, key);
        }
    }

    public int findPivot(int[] arr, int n) {
        int start = 0, end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid < end && arr[mid] > arr[mid + 1]) return mid;
            if (mid > start && arr[mid] < arr[mid - 1]) return mid - 1;

            if (arr[mid] >= arr[start]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    public int binarySearch(int[] arr, int start, int end, int key) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == key) return mid;
            else if (arr[mid] < key) start = mid + 1;
            else end = mid - 1;
        }

        return -1;
    }
}
