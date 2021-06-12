import java.util.Scanner;

class Time {

    int hour;
    int minute;
    int second;
    
    /* Checking if an input is correct is done in the method of()
       so it's safer to keep the constructor private */
       
    private Time(int h, int m, int s) {
        hour = h;
        minute = m;
        second = s;
    }

    public static Time noon() {
        // write your code here
        return new Time(12, 0, 0);
    }

    public static Time midnight() {
        // write your code here
        return new Time(0, 0, 0);
    }

    public static Time ofSeconds(long seconds) {
        // write your code here
        final int SEC_IN_DAY = 60 * 60 * 24;
        int sec = (int) seconds % SEC_IN_DAY;  // ignoring days
        int h = sec / (60 * 60);
        int m = sec / 60 - h * 60;
        int s = sec - 60 * 60 * h - 60 * m;
        
        return new Time(h, m, s);
    }

    public static Time of(int hour, int minute, int second) {
        // write your code here
        return checkTime(hour, minute, second) ? new Time(hour, minute, second) : null;
    }
    
    private static boolean checkTime(int h, int m, int s) {
        return h > -1 && h < 24 && m > -1 && m < 60 && s > -1 && s < 60;
    }
    
}

/* Do not change code below */
public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final String type = scanner.next();
        Time time = null;

        switch (type) {
            case "noon":
                time = Time.noon();
                break;
            case "midnight":
                time = Time.midnight();
                break;
            case "hms":
                int h = scanner.nextInt();
                int m = scanner.nextInt();
                int s = scanner.nextInt();
                time = Time.of(h, m, s);
                break;
            case "seconds":
                time = Time.ofSeconds(scanner.nextInt());
                break;
            default:
                time = null;
                break;
        }

        if (time == null) {
            System.out.println(time);
        } else {
            System.out.println(String.format("%s %s %s", time.hour, time.minute, time.second));
        }
    }
}
