package HW3C;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class HW3CDriver {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the initial list size: ");
        int initialSize = scanner.nextInt();

        System.out.printf("%-15s%-30s%-30s%-30s%-30s%-30s%n", "List Size", "ArrayList addInOrder", "LinkedList addInOrder", "ArrayList addInReverseOrder", "LinkedList addInReverseOrder", "ArrayList addInRandomOrder");

        for (int i = 1; i <= 5; i++) {
            int currentSize = initialSize * (int) Math.pow(2, i - 1);
            ArrayList<Integer> arrayList = new ArrayList<>();
            LinkedList<Integer> linkedList = new LinkedList<>();

            // Measure ArrayList addInOrder
            long startTime = System.currentTimeMillis();
            addInOrder(arrayList, currentSize);
            long endTime = System.currentTimeMillis();
            long arrayListOrderTime = endTime - startTime;

            // Measure LinkedList addInOrder
            startTime = System.currentTimeMillis();
            addInOrder(linkedList, currentSize);
            endTime = System.currentTimeMillis();
            long linkedListOrderTime = endTime - startTime;

            // Measure ArrayList addInReverseOrder
            startTime = System.currentTimeMillis();
            addInReverseOrder(arrayList, currentSize);
            endTime = System.currentTimeMillis();
            long arrayListReverseTime = endTime - startTime;

            // Measure LinkedList addInReverseOrder
            startTime = System.currentTimeMillis();
            addInReverseOrder(linkedList, currentSize);
            endTime = System.currentTimeMillis();
            long linkedListReverseTime = endTime - startTime;

            // Measure ArrayList addInRandomOrder
            startTime = System.currentTimeMillis();
            addInRandomOrder(arrayList, currentSize);
            endTime = System.currentTimeMillis();
            long arrayListRandomTime = endTime - startTime;

            // Measure LinkedList addInRandomOrder
            startTime = System.currentTimeMillis();
            addInRandomOrder(linkedList, currentSize);
            endTime = System.currentTimeMillis();
            long linkedListRandomTime = endTime - startTime;

            // Display the results
            System.out.printf("%-15d%-30d%-30d%-30d%-30d%-30d%n", currentSize, arrayListOrderTime, linkedListOrderTime, arrayListReverseTime, linkedListReverseTime, arrayListRandomTime);
        }

        scanner.close(); // Closing the scanner
    }

    public static void addInOrder(List<Integer> numbers, int n) {
        for (int i = 0; i < n; i++) {
            int index = findInsertIndex(numbers, i);
            numbers.add(index, i);
        }
    }

    public static void addInReverseOrder(List<Integer> numbers, int n) {
        for (int i = n - 1; i >= 0; i--) {
            int index = findInsertIndex(numbers, i);
            numbers.add(index, i);
        }
    }

    public static void addInRandomOrder(List<Integer> numbers, int n) {
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            int randomNum = rand.nextInt(Integer.MAX_VALUE); // Generate a random number
            int index = findInsertIndex(numbers, randomNum);
            numbers.add(index, randomNum);
        }
    }

    // Helper method to find the index for insertion
    private static int findInsertIndex(List<Integer> numbers, int value) {
        int left = 0, right = numbers.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (numbers.get(mid) < value) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}