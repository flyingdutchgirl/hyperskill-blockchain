package bank;

import blockchain.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class Account {
    public final String name;
    private int balance;
    private String passwordHash;
    List<Transaction> history;

    Account(String name, String password) {
        this.name = name;
        this.balance = 100;
        this.history = new ArrayList<>();
        this.passwordHash = StringUtil.applySha256(password);
    }

    boolean pay(Account target, int amount, String password) {
        if (amount > balance) {
            return false;
        }

        if (!StringUtil.applySha256(password).equals(passwordHash)) {
            throw new IllegalArgumentException("Wrong password!");
        }

        target.takeMoney(amount);
        this.balance -= amount;

        return true;
    }

    void takeMoney(int amount) {
        this.balance += amount;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;

        Account account = (Account) o;

        return name.equals(account.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

}
