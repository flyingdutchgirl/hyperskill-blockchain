import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // write your code here
//        String test = "aa2 dV4! 002?? bc3 bc3 002 dv4 bc3 aa2 cgf1 dv4 dv4";
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            sb.append(sc.nextLine());
        }

        tenMostFreqWords(sb.toString()).forEach(System.out::println);
    }

    public static List<String> tenMostFreqWords(String text) {

        String[] words = text.toLowerCase().split("\\s+");
        Map<String, Integer> freq = new HashMap<>();

        Arrays.stream(words)
                .map(str -> str.replaceAll("\\W", ""))
                .forEach(str -> freq.put(str, freq.getOrDefault(str, 0) + 1));


        return freq.entrySet().stream()
                .sorted((e1, e2) -> {
                    int compared = Integer.compare(e2.getValue(), e1.getValue());
                    return compared != 0 ? compared : e1.getKey().compareTo(e2.getKey());
                })
                .limit(10)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

    }

}
