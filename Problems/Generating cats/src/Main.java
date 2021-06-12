import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class GenerateCats {

    public static List<Cat> generateNCats(int n) {
        // write your code here
        return Stream.generate(Cat::new)
                .limit(n)
                .peek(cat -> {
                    cat.name = "Max";
                    cat.age = 7;
                }).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Cat> cats = generateNCats(scanner.nextInt());

        System.out.println(cats.size());
    }
}

class Cat {
    String name;
    int age;
}