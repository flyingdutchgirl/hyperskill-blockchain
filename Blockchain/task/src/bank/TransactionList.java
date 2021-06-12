package bank;

import java.util.ArrayList;
import java.util.List;

public class TransactionList {

    private List<Transaction> transactions;
    private long finalizationTime;

    public TransactionList() {
        transactions = new ArrayList<>();
        finalizationTime = -1;
    }

    public void addTransaction(Transaction t) {
        if (finalizationTime != -1) {
            throw new RuntimeException("This transaction list has been already finalized!");
        }

        transactions.add(t);
    }

    public List<Transaction> getTransactions() {
        return List.copyOf(transactions);
    }

    public void seal() {
        if (finalizationTime == -1) {
            finalizationTime = System.nanoTime();
        }
    }

    @Override
    public String toString() {
        return transactions.stream()
                .map(Transaction::toString)
                .reduce((result, str) -> result + str)
                .orElse("\nNo transactions");
    }
}
