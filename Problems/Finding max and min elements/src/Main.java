import java.util.*;
import java.util.function.*;
import java.util.stream.*;


class MinMax {

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer)
    {
        // your implementation here
        Consumer<T> consumer = new Consumer<>();

        stream.sorted(order).reduce((o, o2) -> )
        consumer.send(minMaxConsumer);
    }

    static class Consumer<T> {
        private boolean wasFirst = false;
        private T first = null;
        private T last = null;

        public void take(T elem) {
            if (wasFirst) {
                last = elem;
            } else {
                wasFirst = true;
                first = elem;
                last = elem;
            }
        }

        public void send(BiConsumer<? super T, ? super T> minMaxConsumer) {
            minMaxConsumer.accept(first, last);
        }
    }

}