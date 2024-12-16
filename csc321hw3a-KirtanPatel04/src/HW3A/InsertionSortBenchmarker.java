package HW3A;

/**
 * The InsertionSortBenchmarker class performs an
 * insertion sort on an int array. It keeps count
 * of the number of swaps, comparisons, and assignments made.
 *
 * @author Kirtan Patel
 */ 
public class InsertionSortBenchmarker {

    private int[] array;  // The array to sort
    private int numSwaps; // To count the number of swaps made
    private int numComparisons; // To count the number of comparisons made
    private int numAssignments; // To count the number of assignments made

    /**
     * Constructor
     * @param inputArray The array to sort.
     */
    public InsertionSortBenchmarker(int[] inputArray) {
        // Directly assign and initialize
        this.array = inputArray.clone();
        this.numSwaps = 0;
        this.numComparisons = 0;
        this.numAssignments = 0;
        this.performSort();
    }

    /**
     * The performSort method performs an insertion sort on the array.
     */
    private void performSort() {
        // The outer loop starts from the second element (index 1)
        for (int i = 1; i < array.length; i++) {
            int currentValue = array[i]; // current unsorted value
            int j = i;  // index pointer for comparison

            numAssignments += 2; // for currentValue and j

            // Move the element to its correct position in the sorted part of the array
            while (j > 0) {
                numComparisons++; // count comparison
                
                if (array[j - 1] > currentValue) {
                    array[j] = array[j - 1]; // shift value
                    j--;
                    numAssignments += 1; // assignment for the shift
                } else {
                    break; // no more shifts needed
                }
            }

            array[j] = currentValue; // final placement of currentValue
            numAssignments++; // assignment outside the loop
            // No swap count here, as insertion sort shifts values instead
        }
    }

    /**
     * Gets the number of swaps.
     * @return The number of swaps.
     */
    public int getNumSwaps() {
        return numSwaps;
    }

    /**
     * Gets the number of comparisons.
     * @return The number of comparisons.
     */
    public int getNumComparisons() {
        return numComparisons;
    }

    /**
     * Gets the number of assignments.
     * @return The number of assignments.
     */
    public int getNumAssignments() {
        return numAssignments;
    }
}
