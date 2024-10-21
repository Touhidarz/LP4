import java.util.Scanner;

public class Daa_Ass1_Fibo_No {

    // Recursive Function
    public static int recur(int n) {
        if (n <= 1) {
            return n;
    }
    else {
            return recur(n - 1) + recur(n - 2);
        }
    }

    // Iterative method (Non-Recursive Function)
    public static void iterative(int n) {
        int a = 0, b = 1;
        System.out.println(a);
        if (n > 1) {
            System.out.println(b);
        }
        for (int i = 2; i < n; i++) {
            int next = a + b;
            System.out.println(next);
            a = b;
            b = next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the nth number for the series: ");
        int num = sc.nextInt();

        if (num <= 0) {
            System.out.println("Please enter a positive integer");
        } else {
            System.out.println("Fibonacci sequence with recursion:");
            for (int i = 0; i < num; i++) {
                System.out.println(recur(i));
            }

            System.out.println("Fibonacci series with Iteration:");
            iterative(num);
        }

        sc.close();
    }
}