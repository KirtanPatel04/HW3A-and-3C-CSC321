package HW3A;

/**
 * The QuickSortBenchmarker class performs a Quicksort on an int array.
 * It keeps count of the number of swaps, comparisons, and assignments made.
 * 
 * @author Kirtan Patel
 */
public class QuickSortBenchmarker {

    private int[] array;  // The array to sort
    private int numSwaps; // To count the number of swaps made
    private int numComparisons; // To count the number of comparisons made
    private int numAssignments; // To count the number of assignments made

    /**
     * Constructor
     * @param inputArray The array to sort.
     */
    public QuickSortBenchmarker(int[] inputArray) {
        this.array = inputArray.clone(); // Clone the input array to avoid side effects
        this.numSwaps = 0;
        this.numComparisons = 0;
        this.numAssignments = 0;
        quickSort(0, array.length - 1); // Start quicksort
    }

    /**
     * The quickSort method uses the Quicksort algorithm to sort the array.
     * @param low The starting index of the sublist to sort.
     * @param high The ending index of the sublist to sort.
     */
    private void quickSort(int low, int high) {
        if (low < high) {
            numComparisons++; // Counting the comparison for recursion check
            int pivotIndex = partition(low, high); // Get the pivot index

            quickSort(low, pivotIndex - 1);  // Recursively sort the left sublist
            quickSort(pivotIndex + 1, high); // Recursively sort the right sublist
        }
    }

    /**
     * The partition method selects a pivot value and arranges the array into two sublists.
     * @param low The starting index of the sublist to partition.
     * @param high The ending index of the sublist to partition.
     * @return The index of the pivot value after partitioning.
     */
    private int partition(int low, int high) {
        int pivotIndex = low + (high - low) / 2;  // Calculate the pivot index
        numAssignments++; // Assignment of pivotIndex

        int pivotValue = array[pivotIndex];  // Save the pivot value for comparisons
        numAssignments++; // Assignment of pivotValue

        swap(low, pivotIndex);  // Move pivot value to the start of the sublist

        int leftPointer = low + 1;  // Start left pointer
        int rightPointer = high;    // Start right pointer
        numAssignments += 2; // Assignments for leftPointer and rightPointer

        while (leftPointer <= rightPointer) {
            while (leftPointer <= rightPointer && array[leftPointer] < pivotValue) {
                leftPointer++; // Move left pointer right until finding a larger value
                numComparisons++; // Comparison for leftPointer condition
            }

            while (leftPointer <= rightPointer && array[rightPointer] >= pivotValue) {
                rightPointer--; // Move right pointer left until finding a smaller value
                numComparisons++; // Comparison for rightPointer condition
            }

            if (leftPointer < rightPointer) {
                swap(leftPointer, rightPointer); // Swap out-of-place values
                leftPointer++;
                rightPointer--;
                numAssignments += 2; // Adjust pointers after swap
            }
        }

        swap(low, rightPointer);  // Swap pivot value back to its correct position
        return rightPointer;      // Return the pivot's final position
    }

    /**
     * Helper method to swap two elements in the array.
     * @param first The index of the first element.
     * @param second The index of the second element.
     */
    private void swap(int first, int second) {
        int temp = array[first];
        numAssignments++; // assignment for temp

        array[first] = array[second];
        numAssignments++; // assignment for first element

        array[second] = temp;
        numAssignments++; // assignment for second element

        numSwaps++; // Counting the swap
    }

    /**
     * Returns the number of swaps made.
     * @return The number of swaps.
     */
    public int getNumSwaps() {
        return numSwaps;
    }

    /**
     * Returns the number of comparisons made.
     * @return The number of comparisons.
     */
    public int getNumComparisons() {
        return numComparisons;
    }

    /**
     * Returns the number of assignments made.
     * @return The number of assignments.
     */
    public int getNumAssignments() {
        return numAssignments;
    }
}

 