import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;

class Utils {

    public final static Comparator<Integer> oddEvenComparator = (i1, i2) -> (Math.abs(i2 % 2) - Math.abs(i1 % 2));
    public final static Comparator<Integer> oddAscending = new ConditionalComparator<>(
            (i1, i2) -> (i1 % 2 != 0 && i2 % 2 != 0),
            Integer::compareTo
    );
    public final static Comparator<Integer> evenDescending = new ConditionalComparator<Integer>(
            (i1, i2) -> (i1 % 2 == 0 && i2 % 2 == 0),
            Comparator.reverseOrder()
    );


    public static List<Integer> sortOddEven(List<Integer> numbers) {
        OrderedComparator<Integer> orderedComparator =
                new OrderedComparator<>(oddEvenComparator, oddAscending, evenDescending);


        numbers.sort(orderedComparator);

        return numbers;
    }

    public static void main(String[] args) {
        Comparator<Integer> oddEvenComparator = (i1, i2) -> (Math.abs(i2 %2) - Math.abs(i1 % 2));
        Comparator<Integer> oddAscending = new ConditionalComparator<>(
                (i1, i2) -> (i1 % 2 != 0 && i2 % 2 != 0),
                Integer::compareTo
        );
        Comparator<Integer> evenDescending = new ConditionalComparator<Integer>(
                (i1, i2) -> (i1 % 2 == 0 && i2 % 2 == 0),
                Comparator.reverseOrder()
        );

        OrderedComparator<Integer> orderedComparator = new OrderedComparator<>(oddEvenComparator, oddAscending, evenDescending);

        Integer[] t1 = {19, 27, 3, 12, 44, 11, 20, 7, 6, 5, 11, 20, 94, 551, 2, 23, 10};
        printArray(t1);
    }

    public static <T> void printArray(T[] arr) {
        for (T elem: arr) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

}


/*
This class takes a number of comparators as constructor arguments and
then applies them in the same order they were given.
 */
class OrderedComparator<T> implements Comparator<T> {
    Comparator<T>[] myComparators;

    @SafeVarargs
    public OrderedComparator(Comparator<T>... comparators) {
        myComparators = comparators;
    }

    @Override
    public int compare(T o1, T o2) {
        int result = 0;

        for (Comparator<T> comp : myComparators) {
            result = comp.compare(o1, o2);
            if (result != 0) {
                return result;
            }
        }

        return result;
    }
}


/*
This class compares only elements that meet a given predicate.
I don't guarantee how it works for not stable sorting algorithms.
 */
class ConditionalComparator<T> implements Comparator<T> {
    private BiFunction<T, T, Boolean> predicate;
    private Comparator<T> comparator;

    public ConditionalComparator(BiFunction<T, T, Boolean> predicate, Comparator<T> comparator) {
        this.predicate = predicate;
        this.comparator = comparator;
    }

    @Override
    public int compare(T o1, T o2) {
        if (predicate.apply(o1, o2)) {
            return comparator.compare(o1, o2);
        } else {
            return 0;
        }
    }
}