import java.util.Arrays;
import java.util.Scanner;

public class Main {

    /**
     * Returns the largest absolute value in the array of numbers.
     *
     * @param numbers the input array of String integer numbers
     * @return the maximum integer absolute value in the array
     */
    public static int maxAbsValue(String[] numbers) {
        // write your code here
        int val = Arrays.stream(numbers)
                .map(Integer::parseInt)
                .reduce(0, (acc, elem) ->
                        Math.abs(elem) > Math.abs(acc) ? elem : acc);

        return Math.abs(val);
    }


    // Don't change the code below
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(maxAbsValue(scanner.nextLine().split("\\s+")));
    }
}