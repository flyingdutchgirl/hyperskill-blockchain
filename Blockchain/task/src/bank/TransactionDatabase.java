package bank;

import blockchain.Block;
import blockchain.ContentSupplier;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TransactionDatabase implements ContentSupplier<TransactionList> {

    private static TransactionList transactionList;
    private static List<Block<TransactionList>> blocks;
    private static List<Account> accounts = new ArrayList<>();


    public TransactionDatabase() {
        transactionList =  new TransactionList();
        blocks = new ArrayList<>();
    }

    @Override
    public synchronized TransactionList blockGenerated(Block<TransactionList> block) {
        blocks.add(block);

        TransactionList oldList = transactionList;
        oldList.seal();
        transactionList = new TransactionList();


        return oldList;
    }


    public synchronized static Account newAccount(String name, String pass) {
        Account acc = new Account(name, pass);

        if (accounts.contains(acc)) {
            throw new IllegalArgumentException("Account with such name already exists!");
        }

        accounts.add(acc);
        return acc;
    }

    public static Account randomAccount(Account myAccount) {
        Account acc = null;
        Random random = new Random();

        do {
            acc = accounts.get(random.nextInt(accounts.size()));
        } while (!acc.equals(myAccount));

        return acc;
    }

    public static boolean makeTransaction(Account from, Account to, int amount, String password) {
        boolean wasPaid = from.pay(to, amount, password);

        if (wasPaid) {
            Transaction transaction = new Transaction(from, to, amount);
            transactionList.addTransaction(transaction);
            to.takeMoney(amount);
        }

        return wasPaid;
    }

}
