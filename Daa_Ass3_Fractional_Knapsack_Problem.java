import java.util.Arrays;
import java.util.Comparator;

class Item {
    int profit, weight;

    public Item(int profit, int weight) {

        this.profit = profit;
        this.weight = weight;
    }
}

public class Daa_Ass3_Fractional_Knapsack_Problem {

    private static double getMaxValue(int capacity, Item[] items) {

        Arrays.sort(items, new Comparator<Item>() {

            @Override public int compare(Item obj1, Item obj2) {

                double r1 = (double) obj1.profit/obj1.weight;
                double r2 = (double) obj2.profit/obj2.weight;

                return Double.compare(r2, r1);
            }
        });

            double totalvalue = 0;
                for(Item item : items) {
                    if(capacity - item.weight >= 0) {
                        capacity -= item.weight;
                            totalvalue += item.profit;
                }
                else {
                    double fraction = ((double) capacity/ item.weight);
                        totalvalue += (item.profit * fraction);
                            break;
            }
        }
                return totalvalue;
    }

    public static void main(String[] args) {
        Item[] item = { new Item(25, 18),
                        new Item(24, 15),    
                        // new Item(120,30)
                        };

                int capacity = 20;
                    double maxValue = getMaxValue(capacity, item);
                        System.out.println("Maximum value we can obtain = " + maxValue);
    }
}