import java.util.Scanner;
import java.util.stream.*;

class Main {

    /**
     * Calculates the factorial of the given number n
     *
     * @param n >= 0
     *
     * @return factorial value
     */
    public static long factorial(long n) {
        // write your code here
        if (n < 0) {
            throw new IllegalArgumentException("Factorial applies for non-negative numbers only!");
        } else if (n == 0) {
            return 1;
        } else {
            return LongStream.rangeClosed(1, n)
                    .reduce((fact, elem) -> fact * elem)
                    .orElseThrow();
        }
    }

    // Don't change the code below
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        long n = Integer.parseInt(scanner.nextLine().trim());

        System.out.println(factorial(n));
    }
}