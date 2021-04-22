package QuickSort_V1;

import java.util.Scanner;

public class QuickSort_V1_Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        System.out.println("Enter the array size: ");
//        int size = in.nextInt();
//        int[] arr = new int[size];
        int[] arr = new int[]{1, 8, 7, 0, 9, 2};

//        System.out.println("Enter the values you need to sort.");
//        for (int i = 0; i < size; i++) {
//            arr[i] = in.nextInt();
//        }
        QuickSort_V1.QuickSort1(arr, 0, arr.length - 1);
        System.out.println("The Sorted Array is: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
