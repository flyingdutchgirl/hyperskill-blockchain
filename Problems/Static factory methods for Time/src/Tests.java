public class Tests {

    public static void main(String[] args) {
        Time t1 = Time.ofSeconds(500000);
        printTime(t1);
    }

    private static String printTime(Time t) {
        String str = t.hour + ":" + t.minute + ":" + t.second;
        System.out.println(str);
        return str;
    }

}

