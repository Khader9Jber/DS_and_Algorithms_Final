package QuickSort_V1;

import java.util.ArrayList;

public class QuickSort_V1 {
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
        // This array will store (after comparison) all elements less than or equals the pivot.
        ArrayList<Integer> before = new ArrayList<>();
        // This array will store (after comparison) all elements greater than the pivot.
        ArrayList<Integer> after = new ArrayList<>();

        // We will choose the last number in the range as a pivot every time.
        int pivot = arr[end];

        // Looping on all numbers except the pivot (the last item),
        // because I need to add it manually.
        for (int i = start; i < end; i++) {
            // If the number which I looping over it currently is less than or equals the pivot,
            // then I will add it before ArrayList.
            if (arr[i] <= pivot) {
                before.add(arr[i]);
            } else { // else => I will add it after ArrayList.
                after.add(arr[i]);
            }
        }

        // In this part I need to refill the original array with the content of ArrayLists.

        // Refilling all numbers less than or equals the pivot in the range before the pivot.
        int index = start - 1;
        for (int i : before)
            arr[++index] = i;

        // Manually adding the pivot between the two parts.
        arr[++index] = pivot;

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
    //
    // - Disadvantages (Shortcomings):
    //   1- Extra Space will be allocated. (High Memory Complexity)
    //   2- If the input array is basically ordered (Ascending or Descending), then it will reach the worst case of partitions. (High Time Complexity O(n^2))
    //   3- If the input array basically consists of the same number or the numbers in the array contain a lot of repetitions,
    //      then the number of partitions will increase and possibly reach the worst case. (High Time Complexity ~ O(n^2))
}
