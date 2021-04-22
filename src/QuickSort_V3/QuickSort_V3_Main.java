package QuickSort_V3;


public class QuickSort_V3_Main {
    public static void main(String[] args) {
        int[] arr = {9, 3, 1, 4, 6, 2, 15, -6, 7, 5, 8, 5, 11};
//        Scanner in = new Scanner(System.in);
//        System.out.println("Enter the array size: ");
//        int size = in.nextInt();
//        int[] arr = new int[size];
//        System.out.println("Enter the values you need to sort.");
//        for (int i = 0; i < size; i++) {
//            arr[i] = in.nextInt();
//        }

        QuickSort_V3.QuickSort2(arr, 0, arr.length - 1);
        System.out.println("The Sorted Array is: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
