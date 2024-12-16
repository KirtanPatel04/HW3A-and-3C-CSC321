package HW3A;

/**
 * The SelectionSortBenchmarker class performs a selection sort on an int array.
 * It keeps count of the number of swaps, comparisons, and assignments made.
 * 
 * Code adapted from textbook archive.
 * 
 * @author Kirtan Patel
 */
public class SelectionSortBenchmarker {

    private int[] array;        // The array to sort
    private int numSwaps;       // To count the number of swaps made
    private int numComparisons; // To count the number of comparisons made
    private int numAssignments; // To count the number of assignments made

    /**
     * Constructor
     * 
     * @param inputArray The array to sort.
     */
    public SelectionSortBenchmarker(int[] inputArray) {
        this.array = inputArray.clone(); // Clone the input array to avoid side effects
        this.numSwaps = 0;
        this.numComparisons = 0;
        this.numAssignments = 0;
        selectionSort(); // Perform selection sort on the array
    }

    /**
     * The selectionSort method performs a selection sort on the array.
     */
    private void selectionSort() {
        // Loop through the array, reducing the unsorted portion each iteration
        for (int startScan = 0; startScan < array.length - 1; startScan++) {
            int minIndex = startScan;    // The index of the smallest element found
            int minValue = array[startScan]; // The value of the smallest element
            numAssignments += 2; // Assigning minIndex and minValue

            // Scan through the unsorted portion of the array
            for (int index = startScan + 1; index < array.length; index++) {
                numComparisons++; // Counting comparison
                if (array[index] < minValue) {
                    minValue = array[index];   // Update the smallest value found
                    minIndex = index;          // Update the index of the smallest value
                    numAssignments += 2;       // Assignments for minValue and minIndex
                }
            }

            // Swap the smallest value found with the element at startScan
            if (minIndex != startScan) {
                swap(minIndex, startScan);
            }
        }
    }

    /**
     * Helper method to swap two elements in the array.
     * 
     * @param firstIndex  The index of the first element to swap.
     * @param secondIndex The index of the second element to swap.
     */
    private void swap(int firstIndex, int secondIndex) {
        int temp = array[firstIndex];  // Temporarily store the value at firstIndex
        numAssignments++;              // Assignment for temp

        array[firstIndex] = array[secondIndex];  // Move value from secondIndex to firstIndex
        numAssignments++;                        // Assignment for firstIndex

        array[secondIndex] = temp;     // Move temp (original value of firstIndex) to secondIndex
        numAssignments++;              // Assignment for secondIndex

        numSwaps++;                    // Count the swap
    }

    /**
     * Returns the number of swaps made during the sorting process.
     * 
     * @return The number of swaps.
     */
    public int getNumSwaps() {
        return numSwaps;
    }

    /**
     * Returns the number of comparisons made during the sorting process.
     * 
     * @return The number of comparisons.
     */
    public int getNumComparisons() {
        return numComparisons;
    }

    /**
     * Returns the number of assignments made during the sorting process.
     * 
     * @return The number of assignments.
     */
    public int getNumAssignments() {
        return numAssignments;
    }
}

 