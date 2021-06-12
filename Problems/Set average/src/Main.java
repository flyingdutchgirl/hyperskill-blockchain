import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class Main {


    public static void main(String[] args) {

        int[] arr = new int[1];
        Supplier<Integer> sup = () -> {arr[0] += 13; Integer a = arr[0] > 135 ? null : arr[0]; return arr[0];};
        Predicate<Integer> pred = (x) -> true;
        var mg = new MyGenerator<Integer>(sup, pred);
        long len = StreamSupport.stream(mg, false).count();
        System.out.println(len);

    }


    static class MyGenerator<T> implements Iterable<T>, Spliterator<T> {

        Supplier<T> gen;
        Predicate<T> stop;
        boolean isNext;
        T next;


        public MyGenerator(Supplier<T> gen, Predicate<T> stop) {
            this.gen = gen;
            this.stop = stop;

            this.next = gen.get();
            this.isNext = stop.test(next);
        }

        @Override
        public Iterator<T> iterator() {
            return new Iterator<T>() {
                @Override
                public boolean hasNext() {
                    return isNext;
                }

                @Override
                public T next() {
                    T result = next;
                    next = gen.get();
                    isNext = stop.test(next);

                    return result;
                }
            };
        }



        @Override
        public void forEach(Consumer<? super T> action) {

        }

        @Override
        public Spliterator<T> spliterator() {
            return null;
        }

        @Override
        public boolean tryAdvance(Consumer<? super T> action) {
            return false;
        }

        @Override
        public Spliterator<T> trySplit() {
            return null;
        }

        @Override
        public long estimateSize() {
            return 0;
        }

        @Override
        public int characteristics() {
            return 0;
        }
    }

}