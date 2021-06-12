import java.util.function.*;

class FunctionUtils {

    public static Supplier<Integer> getInfiniteRange() {
        int[] arr = new int[1];

        return () -> arr[0]++;
    }

}
