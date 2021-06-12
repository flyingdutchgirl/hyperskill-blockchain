import java.util.*;
import java.util.stream.Collectors;


class CollectorPalindrome {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");

        Map<Boolean, List<String>> palindromeOrNo = Arrays.stream(words)
                .collect(
                        Collectors.partitioningBy(
                                word -> {
                                    char[] chars = word.toLowerCase().toCharArray();
                                    boolean result = true;

                                    for (int i = 0, n = chars.length - 1; i < chars.length / 2; i++, n--) {
                                        if (chars[i] != chars[n]) {
                                            result = false;
                                        }
                                    }
                                    return result;
                                }
                        )
                );

        palindromeOrNo = new LinkedHashMap<>(palindromeOrNo);

        System.out.println(palindromeOrNo);
    }
}