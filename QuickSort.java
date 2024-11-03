import java.util.Random;

public class QuickSort {

    // Deterministic variant of Quick Sort (last element as pivot)
    public static void quickSortDeterministic(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSortDeterministic(array, low, pivotIndex - 1);
            quickSortDeterministic(array, pivotIndex + 1, high);
        }
    }

    // Randomized variant of Quick Sort (random pivot)
    public static void quickSortRandomized(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = randomizedPartition(array, low, high);
            quickSortRandomized(array, low, pivotIndex - 1);
            quickSortRandomized(array, pivotIndex + 1, high);
        }
    }

    // Partitioning method for deterministic variant
    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }

    // Partitioning method for randomized variant
    private static int randomizedPartition(int[] array, int low, int high) {
        Random rand = new Random();
        int randomPivotIndex = low + rand.nextInt(high - low);
        swap(array, randomPivotIndex, high); // Move random pivot to end
        return partition(array, low, high);
    }

    // Swap method
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Method to print the array
    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] deterministicArray = {34, 7, 23, 32, 5, 62};
        int[] randomizedArray = deterministicArray.clone();

        System.out.println("Original Array:");
        printArray(deterministicArray);

        // Deterministic Quick Sort
        quickSortDeterministic(deterministicArray, 0, deterministicArray.length - 1);
        System.out.println("Sorted Array (Deterministic Quick Sort):");
        printArray(deterministicArray);

        // Randomized Quick Sort
        quickSortRandomized(randomizedArray, 0, randomizedArray.length - 1);
        System.out.println("Sorted Array (Randomized Quick Sort):");
        printArray(randomizedArray);
    }
}
