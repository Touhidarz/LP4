import java.util.Arrays;

class Item {
    double value;
    double weight;

    Item(double value, double weight) {
        this.value = value;
        this.weight = weight;
    }
}

public class FractionalKnapsack {

    // Method to calculate maximum value
    public static double getMaxValue(Item[] items, double capacity) {
        // Calculate value-to-weight ratio
        double[] ratios = new double[items.length];
        for (int i = 0; i < items.length; i++) {
            ratios[i] = items[i].value / items[i].weight;
        }

        // Sort items based on value-to-weight ratio
        Arrays.sort(items, (a, b) -> Double.compare(b.value / b.weight, a.value / a.weight));

        double totalValue = 0.0;

        for (Item item : items) {
            if (capacity <= 0) {
                break; // No more capacity
            }

            // If the item can be fully added
            if (item.weight <= capacity) {
                totalValue += item.value;
                capacity -= item.weight;
            } else { // Add fraction of the item
                totalValue += item.value * (capacity / item.weight);
                capacity = 0; // Knapsack is now full
            }
        }

        return totalValue;
    }

    // Main method to test the solution
    public static void main(String[] args) {
        Item[] items = {
            new Item(10, 2),   // Value = 60, Weight = 10
            new Item(5, 3),  // Value = 100, Weight = 20
            new Item(15, 5),   // Value = 120, Weight = 30
            new Item(7, 7),   // Value = 120, Weight = 30
            new Item(6, 1),   // Value = 120, Weight = 30
            new Item(18, 4),   // Value = 120, Weight = 30
            new Item(3, 1)  // Value = 120, Weight = 30
        };
        double capacity = 15; // Maximum capacity of the knapsack

        double maxValue = getMaxValue(items, capacity);
        System.out.println("Maximum value in the Knapsack = " + maxValue);
    }
}
