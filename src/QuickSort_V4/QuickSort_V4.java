package QuickSort_V4;

public class QuickSort_V4 {
    // The low and high pointers.
    private static int high, low;

    public static void QuickSort3(int[] arr, int start, int end) {
        // If the arrays consist of one single number, then this array is sorted by default. (start == end)
        // If the starting index is larger than the ending index, then this case range is inverted and it is meaningless. (start > end)
        // In both cases above, the function must stop.
        if (start >= end)
            return;

        // Initializing the pointers.
        high = 0;
        low = 0;

        // Doing a partition operation and returning the index of the pivot.
        partition(arr, start, end);

        // Recurse on the range from start to before pivot.
        QuickSort3(arr, start, low - 1);
        // Recurse on the range from after pivot to end.
        QuickSort3(arr, high + 1, end);
    }

    public static void partition(int[] arr, int start, int end) {
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

        // low begins from the start and all elements before it must be less than the pivot.
        low = start;
        // high begins from the end and all elements after it must be greater than the pivot.
        high = end;
        // ==> the elements in range between low and high must be equals the pivot.

        int i = start;
        // I will stop looping if the iterator exceeds the high pointer.
        while (i <= high) {
            if (arr[i] < pivot) {
                // If I found that there is one of the current numbers less than the pivot,
                // I will replace it with the element that the pointer low refers to it.
                swap(arr, i, low);
                low++;
                i++;
            } else if (arr[i] > pivot) {
                // If I found that there is one of the current numbers greater than the pivot,
                // I will replace it with the element that the pointer high refers to it.
                swap(arr, i, high);
                high--;
            } else {
                // If I found that there is one of the current numbers equal the pivot,
                // I won't do any thing, just I will increment the counter.
                i++;
            }
        }
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
    //   3- I Solved the repetitions problem witch found in V1. (by using median range)
    // - Disadvantages (Shortcomings):
    // 1- Natural Shortcomings for The Quick Sort in General.
}
