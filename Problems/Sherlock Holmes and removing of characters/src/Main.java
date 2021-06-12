import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        String word1 = sc.nextLine();
        String word2 = sc.nextLine();

        var map = LetterCounter.countChars(word1, word2);
        int result = word1.length() + word2.length() - LetterCounter.getBCP(map) * 2;

        System.out.println(result);
        //System.out.println(map.toString());
        //LetterCounter.printMap(map);
    }

}


class LetterCounter {

    public static void printMap(Map<Character, int[]> frequency) {
        var set = frequency.entrySet();

        for (Map.Entry<Character, int[]> entry :
             set) {
            String str = entry.getKey().toString() + " - ";

            for (int i:
                 entry.getValue()) {
                str += (i + ", ");
            }


            System.out.println(str);
        }

    }

    public static Map<Character, int[]> countChars(String word1, String word2) {
        Map<Character, int[]> frequency = new HashMap<>();

        char[] letters1 = word1.toCharArray();
        char[] letters2 = word2.toCharArray();

        for (int i = 0; i < letters1.length; i++) {
            char ch = letters1[i];
            int[] arr = frequency.getOrDefault(ch, new int[]{0, 0});
            arr[0]++;
            frequency.put(ch, arr);
        }

        for (int i = 0; i < letters2.length; i++) {
            char ch = letters2[i];
            int[] arr = frequency.getOrDefault(ch, new int[]{0, 0});
            arr[1]++;
            frequency.put(ch, arr);
        }

        return frequency;
    }

    public static Map<Character, int[]>  biggestCommonPart(String word1, String word2) {
        Map<Character, int[]> frequency = new HashMap<>();

        char[] letters1 = word1.toCharArray();
        char[] letters2 = word2.toCharArray();

        for (int i = 0; i < letters1.length; i++) {
            char ch = letters1[i];
            int[] arr = frequency.getOrDefault(ch, new int[]{0, 0});
            arr[0]++;
            frequency.put(ch, arr);
        }

        for (int i = 0; i < letters2.length; i++) {
            char ch = letters2[i];
            int[] arr = frequency.getOrDefault(ch, new int[]{0, 0});
            arr[1]++;
            frequency.put(ch, arr);
        }

        return frequency;
    }

    public static int getTotalDifference(Map<Character, int[]> frequency) {
        int counter = 0;

        for (int[] arr: frequency.values()) {
            counter += Math.abs(arr[0] - arr[1]);
        }

        return counter;
    }

    public static int getBCP(Map<Character, int[]> frequency) {
        int counter = 0;

        for (int[] arr: frequency.values()) {
            counter += Math.min(arr[0], arr[1]);
        }

        return counter;
    }

}