package QuickSort_V3;

public class QuickSort_V3 {
    public static void QuickSort2(int[] arr, int start, int end) {
        // If the arrays consist of one single number, then this array is sorted by default. (start == end)
        // If the starting index is larger than the ending index, then this case range is inverted and it is meaningless. (start > end)
        // In both cases above, the function must stop.
        if (start >= end)
            return;

        // Doing a partition operation and returning the index of the pivot.
        int pivot = partition(arr, start, end);

        // Recurse on the range from start to before pivot.
        QuickSort2(arr, start, pivot - 1);
        // Recurse on the range from after pivot to end.
        QuickSort2(arr, pivot + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        // Generating a random number in a specific range (from start to end).
        // (int) ((Math.random() * (max - min)) + min);
        // this number we will use to choose and get a random element from this range.
        int randIndex = (int) ((Math.random() * (start - (end))) + (end));

        // Swapping the element located in this random index,
        // with the element located in the last index in this range.
        swap(arr, randIndex, end);

        // Choosing the last element in the range as a pivot every time.
        // (after swap it with the random element => we get a random pivot).
        int pivot = arr[end];

        // The low pointer, it is point to last element less than or equals the pivot.
        int low = start - 1;

        // Looping on all numbers in the range.
        for (int i = start; i <= end; i++) {
            // If I discover that there is one of the current numbers less or equals than the pivot,
            // I will replace it with the element that the pointer refers to after increasing it.
            if (arr[i] <= pivot) {
                swap(arr, i, ++low);
            }
        }
        // Returning the index of the pointer regarding the range (because all numbers before it are less than pivot).
        return low;
    }

    // This simple function to perform swapping operations.
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // - Advantages:
    //   1- I Partially Solved the order array problem witch found in V1. (by picking random index in the range)
    //   2- There are no needs for extra space.
    // - Disadvantages (Shortcomings):
    //   1- If the input array basically consists of the same number or the numbers in the array contain a lot of repetitions,
    //      then the number of partitions will increase and possibly reach the worst case. (High Time Complexity ~ O(n^2))
}
