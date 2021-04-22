package QuickSort_V4;


public class QuickSort_V4_Main {
    public static void main(String[] args) {
        int[] arr = {9, 3, 7, 8, 9, -9, -4, 200, 88, 7, 5, 8, 5};
        QuickSort_V4.QuickSort3(arr, 0, arr.length - 1);
        System.out.println("The Sorted Array is: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
