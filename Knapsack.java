public class Knapsack {

    // Method to solve the 0-1 Knapsack problem
    public static int knapsack(int[] weights, int[] values, int capacity) {
        int n = values.length;
        int[][] dp = new int[n + 1][capacity + 1];

        // Build the DP table
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (weights[i - 1] <= w) {
                    // Take the maximum of including or excluding the item
                    dp[i][w] = Math.max(dp[i - 1][w], values[i - 1] + dp[i - 1][w - weights[i - 1]]);
                } else {
                    // Cannot include the item
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][capacity]; // The maximum value
    }

    // Main method to test the solution
    public static void main(String[] args) {
        int[] weights = {10, 20, 30}; // Weights of the items
        int[] values = {60, 100, 120}; // Values of the items
        int capacity = 50; // Maximum capacity of the knapsack

        int maxValue = knapsack(weights, values, capacity);
        System.out.println("Maximum value in the Knapsack = " + maxValue);
    }
}
