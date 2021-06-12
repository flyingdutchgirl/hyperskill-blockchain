package bank;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;

public class Transaction {

    public final Account from;
    public final Account target;
    public final int amount;
    public final long timeStamp;

    public Transaction(Account from, Account target, int amount) {
        this.from = from;
        this.target = target;
        this.amount = amount;
        this.timeStamp = System.nanoTime();
    }

    public Account getFrom() {
        return from;
    }

    public Account getTarget() {
        return target;
    }

    public int getAmount() {
        return amount;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    @Override
    public String toString() {
        return "\n" + from.getName() + " sent " + amount + " VC to " + target.getName();
    }
}
