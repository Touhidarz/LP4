import java.util.*;

class Item {
    int index;
    int value;
    double weight;

    public Item(int index, int value, double weight) {
        this.index = index;
        this.value = value;
        this.weight = weight;
    }
}

class Node {
    int level, profit, weight;
    List<Integer> contains = new ArrayList<>();
    public int bound;

    public Node() {
        level = -1;
        profit = 0;
        weight = 0;
    }
}

public class Daa_Ass4_01_Knapsack_Problem_BnB {
    public static int bound(Node u, int n, int W, Item[] items) {
        if (u.weight >= W) {
            return 0;
        }

        int profit_bound = u.profit;
        int j = u.level + 1;
        int totweight = u.weight;

        while (j < n && totweight + items[j].weight <= W) {
            totweight += items[j].weight;
            profit_bound += items[j].value;
            j++;
        }

        if (j < n) {
            profit_bound += (W - totweight) * items[j].value / items[j].weight;
        }

        return profit_bound;
    }

    public static Object[] knapSackBranchAndBound(int capacity, Item[] items, int n) {
        Arrays.sort(items, Comparator.comparingDouble(i -> -i.value / i.weight)); // Sort items by value/weight ratio

        Queue<Node> Q = new LinkedList<>();
        Node u = new Node();
        Q.add(u);

        int maxProfit = 0;
        List<Integer> bestItems = new ArrayList<>();

        while (!Q.isEmpty()) {
            u = Q.poll();
            Node v = new Node();

            // Case 1: Moving to the next level
            if (u.level == -1) {
                v.level = 0;
            } else if (u.level == n - 1) {
                continue;
            } else {
                v.level = u.level + 1;
            }

            // Case 2: Take the item
            v.weight = u.weight + (int) items[v.level].weight;
            v.profit = u.profit + items[v.level].value;
            v.contains.addAll(u.contains);
            v.contains.add(items[v.level].index);

            if (v.weight <= capacity && v.profit > maxProfit) {
                maxProfit = v.profit;
                bestItems = new ArrayList<>(v.contains);
            }

            v.bound = bound(v, n, capacity, items);
            if (v.bound > maxProfit) {
                Q.add(v);
            }

            // Case 3: Don't take the item
            v = new Node();
            v.level = u.level + 1;
            v.weight = u.weight;
            v.profit = u.profit;
            v.contains.addAll(u.contains);

            v.bound = bound(v, n, capacity, items);
            if (v.bound > maxProfit) {
                Q.add(v);
            }
        }

        int[] taken = new int[n];
        for (int i : bestItems) {
            taken[i] = 1;
        }

        return new Object[]{maxProfit, Arrays.toString(taken)}; // Return maxProfit as int, and taken as String
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of items: ");
        int itemCount = sc.nextInt();
        System.out.print("Enter the knapsack capacity: ");
        int capacity = sc.nextInt();

        Item[] items = new Item[itemCount];

        // Input item details (value, weight)
        for (int i = 0; i < itemCount; i++) {
            System.out.print("Enter value and weight of item " + (i + 1) + ": ");
            int value = sc.nextInt();
            double weight = sc.nextDouble();
            items[i] = new Item(i, value, weight);
        }

        // Call the Knapsack Branch and Bound method
        Object[] result = knapSackBranchAndBound(capacity, items, itemCount);

        // Output the maximum profit and taken items
        System.out.println("Maximum profit: " + result[0]);
        System.out.println("Items taken: " + result[1]);

        sc.close();
    }
}
