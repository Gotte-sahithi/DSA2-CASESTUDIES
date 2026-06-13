import java.util.Arrays;

// 1. The class name MUST match the filename "JobMatchSort.java" exactly!
public class JobMatchSort {

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; 
        }
        
        int mid = arr.length / 2;
        int[] leftHalf = new int[mid];
        int[] rightHalf = new int[arr.length - mid];

        for (int i = 0; i < mid; i++) {
            leftHalf[i] = arr[i];
        }
        for (int i = mid; i < arr.length; i++) {
            rightHalf[i - mid] = arr[i];
        }

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        merge(arr, leftHalf, rightHalf);
    }

    private static void merge(int[] result, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k] = left[i];
                i++;
            } else {
                result[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < left.length) {
            result[k] = left[i];
            i++;
            k++;
        }

        while (j < right.length) {
            result[k] = right[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        // Your case study data array
        int[] jobMismatchCosts = {38, 27, 43, 3, 9, 82, 10}; // [cite: 19]
        
        System.out.println("Original Mismatch Costs: " + Arrays.toString(jobMismatchCosts));
        
        mergeSort(jobMismatchCosts); // [cite: 14, 28]
        
        System.out.println("Sorted Array: " + Arrays.toString(jobMismatchCosts)); // [cite: 16, 20]
    }
}//CO5
