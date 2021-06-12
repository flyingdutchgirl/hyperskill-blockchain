import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int rotations = sc.nextInt();

        int[] intArray = input.lines()
                .map(line -> line.split("\\s+"))
                .flatMap(Arrays::stream)
                .mapToInt(Integer::parseInt)
                .toArray();

        rightRot(intArray, rotations);

        Arrays.stream(intArray)
                .forEach(i -> System.out.print(i + " "));

    }


    /*
    This implementation may be a little complicated but it's in place (it doesn't require
    allocating memory for a resulting array). This has good and bad sides.
     */
    public static void rightRot(int[] arr, int rotations) {
        int n = 0;
        int last = arr[0];

        for (int i = 0; i < arr.length; i++) {
            int k = (n + rotations) % arr.length;
            int temp = arr[k];
            arr[k] = last;
            last = temp;
            n = k;
        }
    }

}