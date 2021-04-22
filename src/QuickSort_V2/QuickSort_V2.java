package QuickSort_V2;

import java.util.ArrayList;

public class QuickSort_V2 {
    public static void QuickSort1(int[] arr, int start, int end) {
        // If the arrays consist of one single number, then this array is sorted by default. (start == end)
        // If the starting index is larger than the ending index, then this case range is inverted and it is meaningless. (start > end)
        // In both cases above, the function must stop.
        if (start >= end)
            return;

        // Doing a partition operation and returning the index of the pivot.
        int pivot = partition(arr, start, end);

        // Recurse on the range from start to before pivot.
        QuickSort1(arr, start, pivot - 1);

        // Recurse on the range from after pivot to end.
        QuickSort1(arr, pivot + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        // This array will store (after comparison) all elements less than the pivot.
        ArrayList<Integer> before = new ArrayList<>();
        // This array will store (after comparison) all elements greater than the pivot.
        ArrayList<Integer> after = new ArrayList<>();
        // This is a counter to count how many elements are equals to the pivot.
        int equals = 0;

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

        // Looping on all numbers except the pivot (the last item),
        // because I need to add it manually.
        for (int i = start; i < end; i++) {
            // If the number which I looping over it currently is less than the pivot,
            // then I will add it before ArrayList.
            if (arr[i] < pivot) {
                before.add(arr[i]);
            } else if (arr[i] > pivot) { // Else if this number is greater than the pivot, then I will add it after ArrayList.
                after.add(arr[i]);
            } else { // else => this number equals to pivot, we will count it rather than creating a third ArrayList to store it.
                equals++;
            }
        }

        // In this part I need to refill the original array with the content of ArrayLists.

        // Refilling all numbers less than the pivot in the range before the pivot.
        int index = start - 1;
        for (int i : before)
            arr[++index] = i;

        // Refilling all numbers that equals the pivot in the range between after and before ranges.
        // We used do wile because these numbers includes pivot itself at least.
        int j = 0;
        do {
            arr[++index] = pivot;
            j++;
        } while (j < equals);

        // Refilling all numbers greater than the pivot in the range after the pivot.
        for (int i : after)
            arr[++index] = i;

        // Returning the index of the pivot regarding the range.
        return start + before.size();
    }

    // This simple function to perform swapping operations.
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    // - Advantages:
    //   1- Easy to understand, trace, and implement.
    //   2- I Solved the repetitions problem witch found in V1. (by using median range)
    //   3- I Partially Solved the order array problem witch found in V1. (by picking random index in the range)
    // - Disadvantages (Shortcomings):
    //   1- Extra Space will be allocated but not as V1. (High Memory Complexity)

}
