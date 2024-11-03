import java.util.Scanner;

public class Fibonacci {

    // Recursive Function
    public static int Rfibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return Rfibonacci(n - 1) + Rfibonacci(n - 2);
    }

    // Iterative method (Non-Recursive Function)
    public static int NRfibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int a = 0, b = 1, c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
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
                System.out.println(Rfibonacci(i));
            }

            System.out.println("Fibonacci series with Iteration:");
            NRfibonacci(num);
        }

        sc.close();
    }
}