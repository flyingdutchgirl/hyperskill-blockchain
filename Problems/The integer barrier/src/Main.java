import java.util.ArrayList;
import java.util.Base64;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        ArrayList<Integer> numbers = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            numbers.add(sc.nextInt());
        }

        final int BARRIER = 1000;
        int sum = 0;

        for (Integer ii: numbers) {
            sum += ii;

            if (ii == 0) {
                System.out.println(sum);
                break;
            }

            if (sum >= BARRIER) {
                System.out.println(sum - 1000);
                break;
            }
        }

    }
}