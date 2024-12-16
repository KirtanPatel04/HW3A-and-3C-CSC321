package HW3A;

/**
 * The BubbleSortBenchmarker class performs a bubble sort on an int array.
 * It keeps count of the number of swaps, comparisons, and assignments made.
 * 
 * @author Kirtan Patel
 */
public class BubbleSortBenchmarker {

    private int[] array;  // The array to sort.
    private int numSwaps; // To count the number of swaps made.
    private int numComparisons; // To count the number of comparisons made.
    private int numAssignments; // To count the number of assignments made.

    /**
     * Constructor
     * @param inputArray The array to sort.
     */
    public BubbleSortBenchmarker(int[] inputArray) {
        this.array = inputArray.clone(); // Clone array for sorting
        this.numSwaps = 0;
        this.numComparisons = 0;
        this.numAssignments = 0;
        this.performBubbleSort(); // Call sorting method
    }

    /**
     * The performBubbleSort method uses the bubble sort algorithm to sort the array.
     */
    private void performBubbleSort() {
        int n = array.length; // Get the size of the array
        boolean swapped;

        // Outer loop for multiple passes through the array
        do {
            swapped = false; // Reset swap flag
            numAssignments++; // Assignment for swapped

            for (int i = 0; i < n - 1; i++) {
                numComparisons++; // Count comparison
                if (array[i] > array[i + 1]) {
                    // Swap elements if they are in the wrong order
                    swap(i, i + 1);
                    swapped = true; // Set flag to indicate a swap occurred
                    numAssignments++; // Assignment for swapped
                }
            }

            n--; // Reduce the range of comparison in each iteration
            numAssignments++; // Assignment for n
        } while (swapped); // Continue until no swaps occur
    }

    /**
     * Helper method to swap two elements in the array.
     * @param firstIndex Index of the first element to swap.
     * @param secondIndex Index of the second element to swap.
     */
    private void swap(int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        numAssignments++; // temp assignment

        array[firstIndex] = array[secondIndex];
        numAssignments++; // assignment in swap

        array[secondIndex] = temp;
        numAssignments++; // assignment in swap

        numSwaps++; // Count the swap
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
