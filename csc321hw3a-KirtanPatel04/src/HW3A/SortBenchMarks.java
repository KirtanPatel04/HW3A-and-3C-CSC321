package HW3A;

import java.io.File;
import java.util.Scanner;

/**
 * SortBenchMarks class benchmarks different sorting algorithms
 * on the same dataset loaded from a file. The performance of each
 * sorting algorithm (Bubble Sort, Selection Sort, Insertion Sort,
 * and Quick Sort) is measured in terms of swaps, comparisons, and assignments.
 * 
 * @author Kirtan Patel
 */
public class SortBenchMarks {

    /**
     * Constructor for SortBenchMarks. Prompts the user to select a file,
     * loads data from that file, and applies sorting algorithms to benchmark
     * their performance.
     */
    public SortBenchMarks() {
        String prompt = "\n\n\n\nEnter the letter corresponding to the file you wish to process: \n" +
                        "   A - manyNumbers_mixed.csv \n" +
                        "   B - manyNumbers_ascending.csv \n" +
                        "   C - manyNumbers_descending.csv \n" +
                        "\n  or anything else to quit!\n\n";

        System.err.print(prompt);

        Scanner keyBoard = new Scanner(System.in);
        String choice_str = keyBoard.next();
        char choice = choice_str.charAt(0);
        String fileName = "";

        if (choice == 'A' || choice == 'a') {
            fileName = "manyNumbers_mixed.csv";
        } else if (choice == 'B' || choice == 'b') {
            fileName = "manyNumbers_ascending.csv";
        } else if (choice == 'C' || choice == 'c') {
            fileName = "manyNumbers_descending.csv";
        } else {
            System.out.print("No valid choice entered, program terminating!");
            return;
        }

        System.out.println("Working Directory = " + System.getProperty("user.dir"));

        // Load numbers from file
        int[] numbers1 = loadDataFromFile(fileName);
        int[] numbers2 = loadDataFromFile(fileName);
        int[] numbers3 = loadDataFromFile(fileName);
        int[] numbers4 = loadDataFromFile(fileName);

        // Create benchmark objects
        BubbleSortBenchmarker bsort = new BubbleSortBenchmarker(numbers1);
        SelectionSortBenchmarker ssort = new SelectionSortBenchmarker(numbers2);
        InsertionSortBenchmarker isort = new InsertionSortBenchmarker(numbers3);
        QuickSortBenchmarker qsort = new QuickSortBenchmarker(numbers4);

        // Display first and last 5 numbers in sorted lists
        System.err.print("\nBubble sort: first 5 numbers: " + numbers1[0] + ", " + numbers1[1] + ", " +
                          numbers1[2] + ", " + numbers1[3] + ", " + numbers1[4]);
        System.err.print("\nSelection sort: first 5 numbers: " + numbers2[0] + ", " + numbers2[1] + ", " +
                          numbers2[2] + ", " + numbers2[3] + ", " + numbers2[4]);
        System.err.print("\nInsertion sort: first 5 numbers: " + numbers3[0] + ", " + numbers3[1] + ", " +
                          numbers3[2] + ", " + numbers3[3] + ", " + numbers3[4]);
        System.err.print("\nQuick sort: first 5 numbers: " + numbers4[0] + ", " + numbers4[1] + ", " +
                          numbers4[2] + ", " + numbers4[3] + ", " + numbers4[4]);

        System.err.print("\n\nBubble sort: last 5 numbers: " + numbers1[1495] + ", " + numbers1[1496] + ", " +
                          numbers1[1497] + ", " + numbers1[1498] + ", " + numbers1[1499]);
        System.err.print("\nSelection sort: last 5 numbers: " + numbers2[1495] + ", " + numbers2[1496] + ", " +
                          numbers2[1497] + ", " + numbers2[1498] + ", " + numbers2[1499]);
        System.err.print("\nInsertion sort: last 5 numbers: " + numbers3[1495] + ", " + numbers3[1496] + ", " +
                          numbers3[1497] + ", " + numbers3[1498] + ", " + numbers3[1499]);
        System.err.print("\nQuick sort: last 5 numbers: " + numbers4[1495] + ", " + numbers4[1496] + ", " +
                          numbers4[1497] + ", " + numbers4[1498] + ", " + numbers4[1499]);

        // Display swaps, comparisons, and assignments for each sorting algorithm
        System.out.println("\n\nBubble sort: Swaps = " + bsort.getNumSwaps() +
                           ", Comparisons = " + bsort.getNumComparisons() +
                           ", Assignments = " + bsort.getNumAssignments());

        System.out.println("Selection sort: Swaps = " + ssort.getNumSwaps() +
                           ", Comparisons = " + ssort.getNumComparisons() +
                           ", Assignments = " + ssort.getNumAssignments());

        System.out.println("Insertion sort: Swaps = " + isort.getNumSwaps() +
                           ", Comparisons = " + isort.getNumComparisons() +
                           ", Assignments = " + isort.getNumAssignments());

        System.out.println("Quick sort: Swaps = " + qsort.getNumSwaps() +
                           ", Comparisons = " + qsort.getNumComparisons() +
                           ", Assignments = " + qsort.getNumAssignments());
    }

    /**
     * Loads integer data from a file.
     *
     * @param fileName The name of the file to load data from.
     * @return An array of integers from the file.
     */
    private static int[] loadDataFromFile(String fileName) {
        File file = new File(fileName);
        int[] numbers = new int[1500];

        try {
            Scanner scanner = new Scanner(file);
            int index = 0;
            while (scanner.hasNext()) {
                numbers[index] = scanner.nextInt();
                index++;
            }
        } catch (Exception e) {
            System.err.print(e.toString());
        }

        return numbers;
    }

    /**
     * Main method to launch the sorting benchmark.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        SortBenchMarks sbm = new SortBenchMarks();
    }
}
